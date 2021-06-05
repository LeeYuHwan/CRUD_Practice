package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entity.Member;
import entity.MemberType;

public class Main {
	public static void main(String[] args) {
		//엔티티 매니저 팩토리는 하나만 생성해서 애플리케이션 전체에서 공유
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		
		//엔티티 매니저는 쓰레드간에 공유하면 안된다(사용하고 버려야 한다).
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		//JPA의 모든 변경은 트랜잭션 안에서 실행하여야함.
		tx.begin();
		
		try {
			Member member = new Member();
			//member.setId(100L);
			member.setName("안녕하세요");
			member.setAge(1);
			member.setMemberType(MemberType.ADMIN);
			
			em.persist(member);
			
			tx.commit();
		}catch(Exception e) {
			tx.rollback();
		}finally {
			em.close();
		}
		
		emf.close();
	}
}
