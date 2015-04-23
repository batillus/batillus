package NaRaene.NaRaene.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

	@Entity
	@Table(name = "player")
	public class Player {
	

	public int getStrength() {
			return strength;
		}

		public void setStrength(int strength) {
			this.strength = strength;
		}

		public int getHp() {
			return hp;
		}

		public void setHp(int hp) {
			this.hp = hp;
		}

	@Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 @Column(name="id", columnDefinition = "int(11)")
	 private long playerId;
	 
	 @Column(name = "player_name", columnDefinition = "char(32)")
	 private String playerName;
	 
	 @Column(name = "type", columnDefinition = "char(100)")
	 private String type;

	 @Column(name="user_id", columnDefinition = "int(11)")
	  private long userId;
	 
	 @Column(name="strength", columnDefinition = "int(11)")
	  private int strength;
	 
	 @Column(name="hp", columnDefinition = "int(11)")
	  private int hp;

		 public Player(){
			 
		 }
		 
		 public Player(String playerName, String type, long userId, int strength, int hp){
			 this.playerName = playerName;
			 this.type = type;
			 this.userId = userId;
			 this.strength = strength;
			 this.hp = hp;
		 }
		 
		 public long getPlayerId() {
				return playerId;
			}

			public void setPlayerId(long playerId) {
				this.playerId = playerId;
			}

			public String getPlayerName() {
				return playerName;
			}

			public void setPlayerName(String playerName) {
				this.playerName = playerName;
			}

			public String getType() {
				return type;
			}

			public void setType(String type) {
				this.type = type;
			}

			public long getUserId() {
				return userId;
			}

			public void setUserId(long userId) {
				this.userId = userId;
			}
	}
