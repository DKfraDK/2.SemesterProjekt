package model;

public class Tørretid {
	private String tid;
	private Delbehandling delbehandling = null;
	
	
	Tørretid(String tid, Delbehandling delbehandling){
		this.setTid(tid);
		this.delbehandling=delbehandling;
		
	}
	
	public Delbehandling getDelbehandling(){
		return delbehandling;
	}
	public void setDelbehandling(Delbehandling delbehandling){
		if(this.delbehandling!=delbehandling){
			this.delbehandling=delbehandling;
		}
	}

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

}
