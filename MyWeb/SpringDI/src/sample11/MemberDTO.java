package sample11;

public class MemberDTO {
	private String name;
	private String id;
	private String joindate;
	
	public MemberDTO(String name, String id, String joindate) {
		super();
		this.name = name;
		this.id = id;
		this.joindate = joindate;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}

	public String getJoindate() {
		return joindate;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setJoindate(String joindate) {
		this.joindate = joindate;
	}
	
}
