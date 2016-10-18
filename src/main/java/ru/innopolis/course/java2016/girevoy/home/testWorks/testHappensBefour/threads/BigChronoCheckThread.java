package ru.innopolis.course.java2016.girevoy.home.testWorks.testHappensBefour.threads;

/**
 * Created by masterlomaster on 07.10.16.
 */
public class BigChronoCheckThread extends Thread{
	private int quant;
	private boolean marker;


	public boolean isMarker() {
		return marker;
	}
	public void setMarker(boolean marker) {
		this.marker = marker;
	}

	public BigChronoCheckThread(int quant) {
		this.setDaemon(true);
		this.quant = quant;
	}

	public void run() {		//WARNING! Как на самом деле закрываются демоны
		while (!isInterrupted()) {
			synchronized (this) {
				try {
					do {
						this.wait();
					} while (!marker);
					System.out.println("Прошло " + quant + " секунд");
					marker = false;
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public int getQuant() {
		return this.quant;
	}

	public void setQuant(int quant) {
		this.quant = quant;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		BigChronoCheckThread that = (BigChronoCheckThread) o;

		return quant == that.quant;

	}

	@Override
	public int hashCode() {
		return quant;
	}
}
