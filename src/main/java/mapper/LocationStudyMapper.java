package mapper;


import model.LocationStudy;
import model.LocationStudyKey;

public interface LocationStudyMapper {
    int deleteByPrimaryKey(LocationStudyKey key);

    int insert(LocationStudy record);

    int insertSelective(LocationStudy record);

    LocationStudy selectByPrimaryKey(LocationStudyKey key);

    int updateByPrimaryKeySelective(LocationStudy record);

    int updateByPrimaryKey(LocationStudy record);
}