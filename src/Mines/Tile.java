package Mines;

import javax.net.ssl.SSLEngineResult.Status;

public abstract class Tile {

	private TileStatus status;

	public TileStatus getTileStatus() {
		return status;
	}

	public void setTileStatus(TileStatus status) {
		this.status = status;
	}
		
	
	
}
