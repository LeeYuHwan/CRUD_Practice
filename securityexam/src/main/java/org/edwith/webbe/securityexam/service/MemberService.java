package org.edwith.webbe.securityexam.service;

import org.edwith.webbe.securityexam.dto.Member;
import org.edwith.webbe.securityexam.service.security.UserDbService;

public interface MemberService extends UserDbService {

	void addMember(Member member, boolean admin);

	Member getMemberByEmail(String loginId);

}