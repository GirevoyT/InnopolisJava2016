package ru.innopolis.course.java2016.girevoy.lessons.lesson17.testPattern3;

/**
 * Created by oem on 25.10.16.
 */
public class Bank {
	private final Vklad vklad;
	private final Strahovka strahovka;
	private final Credite credite;

	private Bank(BankBuilder bankBuilder) {
		this.vklad = bankBuilder.vklad;
		this.strahovka = bankBuilder.strahovka;
		this.credite = bankBuilder.credite;
	};

	private String Reklama() {
		String DELIMETR = " ";
		return new StringBuilder(vklad.toString())
				.append(DELIMETR)
				.append(strahovka)
				.append(DELIMETR)
				.append(credite).toString();
	}
	public static class BankBuilder {
		private Vklad vklad;
		private Strahovka strahovka;
		private Credite credite;

		public BankBuilder withVklad(String vklad) {
			this.vklad = new Vklad();
			this.vklad.setDescription(vklad);
			return this;
		}

		public BankBuilder withStrahovka(String strahovka) {
			this.strahovka = new Strahovka();
			this.strahovka.setDescription(strahovka);
			return this;
		}

		public BankBuilder withCredite(String credite) {
			this.credite = new Credite();
			this.credite.setDescription(credite);
			return this;
		}
		public Bank build() {
			return new Bank(this);
		}
	}
}
