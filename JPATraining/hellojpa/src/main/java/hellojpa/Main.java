package hellojpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entity.Member;
import entity.MemberType;
import entity.Team;

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
			Team team = new Team();
			team.setName("teamA");
			em.persist(team);
			
			Member member = new Member();		
			//member.setId(100L);
			member.setName("안녕하세요");
			member.setAge(1);
			//member.setTeamId(team.getId());
			
			//주인상태인 Member에게 setTeam을 해줘야 team id가 자동 업데이트됨
			member.setTeam(team);
			member.setMemberType(MemberType.ADMIN);			
			
			em.persist(member);
			
			//주인상태가 아닌 team에게 member를 add하면 team id가 자동 업데이트가 되지 않아 null값이 들어간다.
			//team.getMembers().add(member);
			//**순수한 객체 관계를 고려하면 항상 양쪽다 값을 입력해야 한다.
					
			//쿼리 보여줌
			em.flush();
			em.clear();
			
			//조회
			Member findMember = em.find(Member.class, member.getId());
			/*//객체지향적이지 못한 방법 - JPA를 사용하지 않을때
			Long teamId = findMember.getTeamId();		
			Team findTeam = em.find(Team.class, teamId);*/
			
			//객체지향적인 방법 - JPA의 기능
			Team findTeam = findMember.getTeam();
			findTeam.getName();
			
			//역방향 조회
			List<Member> members = findTeam.getMembers();
			for(Member member1 : members) {
				System.out.println("member1 = " + member1);
			}
			
			tx.commit();
		}catch(Exception e) {
			tx.rollback();
		}finally {
			em.close();
		}
		
		emf.close();
	}
}
