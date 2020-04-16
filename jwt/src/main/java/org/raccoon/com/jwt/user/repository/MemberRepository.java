package org.raccoon.com.jwt.user.repository;

import org.raccoon.com.jwt.user.domain.Member;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends CrudRepository<Member, String> {

}
