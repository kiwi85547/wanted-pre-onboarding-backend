package com.wantedpreonboardingbackend.mapper;

import com.wantedpreonboardingbackend.domain.RecruitNotice;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

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
}
