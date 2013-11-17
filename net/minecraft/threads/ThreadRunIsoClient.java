package net.minecraft.threads;

import net.minecraft.src.CanvasIsomPreview;

public class ThreadRunIsoClient extends Thread {
	final CanvasIsomPreview field_1197_a;

	public ThreadRunIsoClient(CanvasIsomPreview par1CanvasIsomPreview) {
		field_1197_a = par1CanvasIsomPreview;
	}

        @Override
	public void run() {
		while (CanvasIsomPreview.isRunning(field_1197_a)) {
			field_1197_a.render();

			try {
				Thread.sleep(1L);
			} catch (Exception exception) {
			}
		}
	}
}
