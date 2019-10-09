package mapper;

import model.SponsorStudy;
import model.SponsorStudyKey;

public interface SponsorStudyMapper {
    int deleteByPrimaryKey(SponsorStudyKey key);

    int insert(SponsorStudy record);

    int insertSelective(SponsorStudy record);

    SponsorStudy selectByPrimaryKey(SponsorStudyKey key);

    int updateByPrimaryKeySelective(SponsorStudy record);

    int updateByPrimaryKey(SponsorStudy record);
}