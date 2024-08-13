package com.wantedpreonboardingbackend.mapper;

import com.wantedpreonboardingbackend.domain.RecruitNotice;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

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
                region, 
                created_at
            ) VALUES (
                #{companyId}, 
                #{position}, 
                #{salary}, 
                #{content}, 
                #{techStack}, 
                #{country}, 
                #{region}, 
                #{createdAt}
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
}
