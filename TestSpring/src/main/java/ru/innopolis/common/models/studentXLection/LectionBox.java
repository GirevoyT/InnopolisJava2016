package ru.innopolis.common.models.studentXLection;

import ru.innopolis.common.models.lection.Lection;

/**
 * Класс обертка для хранения экземпляра лекции и статуса посещена/не посещена
 */
public class LectionBox {
	private Lection lection;
	private boolean presence;

	public Lection getLection() {
		return lection;
	}

	public void setLection(Lection lection) {
		this.lection = lection;
	}

	public boolean isPresence() {
		return presence;
	}

	public void setPresence(boolean presence) {
		this.presence = presence;
	}
}
