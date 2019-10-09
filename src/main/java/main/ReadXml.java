package main;


import mapper.*;
import model.*;
import org.apache.ibatis.session.SqlSession;
import org.dom4j.Element;
import util.MybatisUtil;

import java.util.ArrayList;
import java.util.List;

public class ReadXml {
    public void getNodes(Element node) {

        SqlSession sqlSession = MybatisUtil.createSqlSession();

        StudyWithBLOBs study = new StudyWithBLOBs();

        String nctId = node.element("id_info").elementText("nct_id");
        StudyMapper studyMapper = sqlSession.getMapper(StudyMapper.class);
        try {
            //build clinical results
            Element clinicalResults = node.element("clinical_results");
            if (clinicalResults != null) {
                // build contact


                ContactMapper contactMapper = sqlSession.getMapper(ContactMapper.class);
                Contact contact = BuildContact.buildContact(clinicalResults);
                if (contact != null) {
                    contactMapper.insert(contact);
                    study.setContactId(contact.getContactId());

                }

                // out come
                OutcomeMapper outcomeMapper = sqlSession.getMapper(OutcomeMapper.class);

                Element outcomelist = clinicalResults.element("outcome_list");
                if (outcomelist != null) {
                    List<Element> outcomes = outcomelist.elements("outcome");

                    for (Element outCome : outcomes) {
                        Outcome outcome = new Outcome();
                        outcome.setOutcomeDescripition(outCome.elementText("description"));
                        outcome.setOutcomeTitle(outCome.elementText("title"));
                        outcome.setOutcomeType(outCome.elementText("type"));
                        outcome.setNctId(nctId);
                        if (outcomeMapper.selectByPrimaryKey(outcome) == null) {
                            outcomeMapper.insert(outcome);
                        }

                    }
                }
            }

            // build criteria
            Element eligibility = node.element("eligibility");
            if (eligibility != null) {
                Criteria criteria = BuildCriteria.buildCriteria(eligibility);
                if (criteria != null) {
                    CriteriaMapper criteriaMapper = sqlSession.getMapper(CriteriaMapper.class);
                    criteriaMapper.insert(criteria);
                    study.setCriterId(criteria.getCriterId());
                }
            }

            List<Element> locations = node.elements("location");

            LocationStudyMapper locationStudyMapper = sqlSession.getMapper(LocationStudyMapper.class);
            LocationMapper locationMapper = sqlSession.getMapper(LocationMapper.class);

            try {
                for (Element location : locations) {
                    LocationStudy locationStudy = BuildLocationStudy.build(location, nctId);
                    Location lo = BuildLocation.build(location);
                    if (lo != null && locationMapper.selectByPrimaryKey(lo.getZip()) == null) {
                        locationMapper.insert(lo);

                        LocationStudyKey lk = new LocationStudyKey();
                        lk.setNctId(nctId);
                        lk.setZip(lo.getZip());
                        if (locationStudy != null && locationStudyMapper.selectByPrimaryKey(lk) == null) {
                            locationStudyMapper.insert(locationStudy);
                        }
                    }


                }
            } catch (Exception e) {
                sqlSession.close();
                return;
            }

            Element sponsors = node.element("sponsors");
            if (sponsors != null) {
                // lead sponsor
                SponsorMapper sponsorMapper = sqlSession.getMapper(SponsorMapper.class);
                SponsorStudyMapper sponsorStudyMapper = sqlSession.getMapper(SponsorStudyMapper.class);

                Element leadElement = sponsors.element("lead_sponsor");
                if (leadElement != null) {
                    // lead sponsor
                    Sponsor leadSponsor = BuildSponsor.build(leadElement);

                    int leadSid = getSponsorId(sponsorMapper, leadSponsor);
                    SponsorStudy sponsorStudy = new SponsorStudy();
                    sponsorStudy.setSponsorType("leader");
                    sponsorStudy.setNctId(nctId);
                    sponsorStudy.setSponsorId(leadSid);
                    sponsorStudyMapper.insert(sponsorStudy);
                }

                List<Element> collaborators = sponsors.elements("collaborator");
                for (Element coll : collaborators) {
                    Sponsor collaborator = BuildSponsor.build(coll);
                    int collId = getSponsorId(sponsorMapper, collaborator);
                    SponsorStudy sponsorStudy = new SponsorStudy();
                    sponsorStudy.setSponsorType("collaborator");
                    sponsorStudy.setNctId(nctId);
                    sponsorStudy.setSponsorId(collId);
                    sponsorStudyMapper.insert(sponsorStudy);
                }
            }


            List<Element> keywords = node.elements("keyword");
            List<String> keywordList = new ArrayList<String>();

            for (Element kw : keywords) {
                keywordList.add(kw.getTextTrim());
            }

            KeywordMapper keywordMapper = sqlSession.getMapper(KeywordMapper.class);
            KeywordStudyMapper keywordStudyMapper = sqlSession.getMapper(KeywordStudyMapper.class);
            for (String keyword : keywordList) {
                Keyword kw = new Keyword();
                kw.setKeyword(keyword);
                int keywordId;
                Keyword searchkw = keywordMapper.select(kw);
                if (searchkw != null) {
                    keywordId = searchkw.getKeywordId();

                } else {
                    keywordMapper.insert(kw);
                    keywordId = kw.getKeywordId();
                }
                KeywordStudyKey keywordStudy = new KeywordStudyKey();
                keywordStudy.setKeywordId(keywordId);
                keywordStudy.setNctId(nctId);
                keywordStudyMapper.insert(keywordStudy);
            }


            InteroberMapper interoberMapper = sqlSession.getMapper(InteroberMapper.class);
            InteroberStudyMapper interoberStudyMapper = sqlSession.getMapper(InteroberStudyMapper.class);

            Element interober = node.element("intervention");
            if (interober != null) {
                Interober inter = new Interober();
                inter.setInteroberDescription(interober.elementText("description"));
                inter.setInteroberName(interober.elementText("intervention_name"));
                inter.setInteroberType(interober.elementText("intervention_type"));
                interoberMapper.insert(inter);
                InteroberStudyKey interoberStudyKey = new InteroberStudyKey();
                interoberStudyKey.setInteroberId(inter.getInteroberId());
                interoberStudyKey.setNctId(nctId);
                interoberStudyMapper.insert(interoberStudyKey);
            }

            study.setUrl(node.element("required_header").elementText("url"));
            study.setNctId(nctId);
            study.setBriefTitle(node.elementText("brief_title"));
            study.setOfficialTitle(node.elementText("official_title"));
            study.setSource(node.elementText("source"));
            study.setOverallStatus(node.elementText("overall_status"));
            study.setPhase(node.elementText("phase"));
            study.setStudyType(node.elementText("study_type"));
            study.setStudyFirstSubmitted(node.elementText("study_first_submitted"));
            study.setResultsFirstSubmitted(node.elementText("results_first_submitted"));
            study.setBriefSummary(node.elementText("brief_summary"));
            study.setDetailedDescription(node.elementText("detailed_description"));
            study.setOfficialTitle(node.elementText("official_title"));
            study.setStartDate(node.elementText("start_date"));

            studyMapper.insert(study);
        } catch (Exception e) {
            sqlSession.close();
            return;
        }

        sqlSession.commit();
        sqlSession.close();

    }


    private Integer getSponsorId(SponsorMapper sponsorMapper, Sponsor sponsor) {
        int sponrId;
        Sponsor searchLead = sponsorMapper.select(sponsor);
        if (searchLead != null) {
            sponrId = searchLead.getSponsorId();
        } else {
            sponsorMapper.insert(sponsor);
            sponrId = sponsor.getSponsorId();
        }
        return sponrId;
    }
}
