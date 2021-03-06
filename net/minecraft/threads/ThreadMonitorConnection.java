package net.minecraft.threads;

import net.minecraft.network.NetworkManager;

public class ThreadMonitorConnection extends Thread {
	/** Reference to the NetworkManager object. */
	final NetworkManager netManager;

	public ThreadMonitorConnection(NetworkManager par1NetworkManager) {
		netManager = par1NetworkManager;
	}

        @Override
	public void run() {
		try {
			Thread.sleep(2000L);

			if (NetworkManager.isRunning(netManager)) {
				NetworkManager.getWriteThread(netManager).interrupt();
				netManager.networkShutdown("disconnect.closed", new Object[0]);
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}
}
