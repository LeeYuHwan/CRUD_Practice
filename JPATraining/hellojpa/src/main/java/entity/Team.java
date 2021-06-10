package entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Team {
	
	@Id @GeneratedValue
	private Long id;
	private String name;
	
	//설계 권장 가이드 : 일단 단방향으로 설계 후 개발 하면서 양방향이 필요할시 양방향 추가할것을 권장
	//주인을 정하는 기준 : 외래키가 있는 곳을 주인으로 정함 이경우는 Member가 외래키가 있으므로 주인임
	//주인은 mappedBy속성 사용x 오직 주인이 아닌 경우만 mappedBy속성 사용
	//team은 연관관계 주인이 아님 mappedBy로 주인이 아님을 밝힘 그러므로 이것은 오직 read역할만 수행 자동 업데이트x
	@OneToMany(mappedBy = "team")
	private List<Member> members = new ArrayList<Member>();
	
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
	public List<Member> getMembers() {
		return members;
	}
	public void setMembers(List<Member> members) {
		this.members = members;
	}
}
