package mapper;


import model.Sponsor;

public interface SponsorMapper {
    int deleteByPrimaryKey(Integer sponsorId);

    int insert(Sponsor record);

    int insertSelective(Sponsor record);

    Sponsor selectByPrimaryKey(Integer sponsorId);

    int updateByPrimaryKeySelective(Sponsor record);

    int updateByPrimaryKey(Sponsor record);

    Sponsor select(Sponsor record);
}