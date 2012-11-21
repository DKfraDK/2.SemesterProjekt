package model;

public class Toerretid {
	private int tid;
	private Delbehandling delbehandling = null;
	
	
	Toerretid(int tid, Delbehandling delbehandling){
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

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

}
