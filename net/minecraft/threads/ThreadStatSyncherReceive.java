package net.minecraft.threads;

import java.io.File;
import net.minecraft.stats.StatsSyncher;

public class ThreadStatSyncherReceive extends Thread {
	public final StatsSyncher syncher;

	public ThreadStatSyncherReceive(StatsSyncher par1StatsSyncher) {
		syncher = par1StatsSyncher;
	}

        @Override
	public void run() {
		try {
			if (StatsSyncher.func_27422_a(syncher) != null) {
				StatsSyncher.func_27412_a(syncher,
						StatsSyncher.func_27422_a(syncher),
						StatsSyncher.func_27423_b(syncher),
						StatsSyncher.func_27411_c(syncher),
						StatsSyncher.func_27413_d(syncher));
			} else if (StatsSyncher.func_27423_b(syncher).exists()) {
				StatsSyncher.func_27421_a(syncher, StatsSyncher.func_27409_a(
						syncher, StatsSyncher.func_27423_b(syncher),
						StatsSyncher.func_27411_c(syncher),
						StatsSyncher.func_27413_d(syncher)));
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		} finally {
			StatsSyncher.setBusy(syncher, false);
		}
	}
}
