package com.wantedpreonboardingbackend.mapper;

import com.wantedpreonboardingbackend.domain.RecruitNotice;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface BoardMapper {
    @Insert("""
            INSERT INTO recruit_notice(
                company_id, 
                position, 
                salary, 
                content, 
                tech_stack, 
                country, 
                region
            ) VALUES (
                #{companyId}, 
                #{position}, 
                #{salary}, 
                #{content}, 
                #{techStack}, 
                #{country}, 
                #{region}
            )
            """)
    int insertRecruit(RecruitNotice recruitNotice);

    @Select("""
            SELECT *, company.company_name FROM recruit_notice notice LEFT JOIN company ON notice.company_id = company.company_id
            """)
    List<Map<String, Object>> selectList();

    @Select("""
            SELECT *, company.company_name FROM recruit_notice notice LEFT JOIN company ON notice.company_id = company.company_id WHERE notice.recruit_id = #{recruitId}
            """)
    Map<String, Object> selectRecruitById(Integer recruitId);

    @Update("""
            UPDATE recruit_notice 
            SET position = #{position}, 
                salary = #{salary},
                content = #{content}, 
                tech_stack = #{techStack}, 
                country = #{country}, 
                region = #{region}
            WHERE recruit_id = #{recruitId}
            """)
    int updateRecruitById(RecruitNotice recruitNotice);

    @Delete("""
            DELETE FROM recruit_notice WHERE recruit_id = #{recruitId}
            """)
    int deleteRecruitById(Integer recruitId);
}
