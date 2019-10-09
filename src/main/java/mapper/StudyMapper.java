package mapper;

import model.Study;
import model.StudyWithBLOBs;

public interface StudyMapper {
    int deleteByPrimaryKey(String nctId);

    int insert(StudyWithBLOBs record);

    int insertSelective(StudyWithBLOBs record);

    StudyWithBLOBs selectByPrimaryKey(String nctId);

    int updateByPrimaryKeySelective(StudyWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(StudyWithBLOBs record);

    int updateByPrimaryKey(Study record);
}