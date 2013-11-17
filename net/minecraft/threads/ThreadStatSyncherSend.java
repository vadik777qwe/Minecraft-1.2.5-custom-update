package net.minecraft.threads;

import java.util.Map;
import net.minecraft.stats.StatsSyncher;

public class ThreadStatSyncherSend extends Thread {
	final Map field_27233_a;
	final StatsSyncher syncher;

	public ThreadStatSyncherSend(StatsSyncher par1StatsSyncher, Map par2Map) {
		syncher = par1StatsSyncher;
		field_27233_a = par2Map;
	}

        @Override
	public void run() {
		try {
			StatsSyncher.func_27412_a(syncher, field_27233_a,
					StatsSyncher.getUnsentDataFile(syncher),
					StatsSyncher.getUnsentTempFile(syncher),
					StatsSyncher.getUnsentOldFile(syncher));
		} catch (Exception exception) {
			exception.printStackTrace();
		} finally {
			StatsSyncher.setBusy(syncher, false);
		}
	}
}
