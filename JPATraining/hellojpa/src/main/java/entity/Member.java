package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//다양한 매핑 어노테이션들
//@Column
//@Temporal
//@Enumerated
//@Lob
//@Transient

//식별자 매핑 어노테이션
//@Id
//@GeneratedValue

@Entity
public class Member {
	
	//GenerationType.AUTO = 자동 시퀀스 생성
	//기본 키 제약 조건: not null, 유일, 변하면 안됨
	//하지만 미래까지 이 조건을 만족하는 자연키는 찾기 어렵다. 대리키(대체키)를 사용하자.
	//권장 : Long + 대체키 + 키 생성전략 사용
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	//컬럼은 DB와 매핑하는 역할
	@Column(name = "USERNAME", nullable = false, length = 200)
	private String name;
	private int age;
	
	//꼭 String으로 쓸것
	@Enumerated(EnumType.STRING)
	private MemberType memberType;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public MemberType getMemberType() {
		return memberType;
	}
	public void setMemberType(MemberType memberType) {
		this.memberType = memberType;
	}
}
