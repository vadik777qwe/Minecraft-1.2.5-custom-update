package net.minecraft.world.anvil;

import net.minecraft.world.WorldProviderHell;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.WorldProviderEnd;
import net.minecraft.world.WorldInfo;
import java.io.File;
import java.util.List;
import net.minecraft.src.IChunkLoader;
import net.minecraft.world.save.SaveHandler;

public class AnvilSaveHandler extends SaveHandler {
	public AnvilSaveHandler(File par1File, String par2Str, boolean par3) {
		super(par1File, par2Str, par3);
	}

	/**
	 * Returns the chunk loader with the provided world provider
	 */
	public IChunkLoader getChunkLoader(WorldProvider par1WorldProvider) {
		File file = getSaveDirectory();

		if (par1WorldProvider instanceof WorldProviderHell) {
			File file1 = new File(file, "DIM-1");
			file1.mkdirs();
			return new AnvilChunkLoader(file1);
		}

		if (par1WorldProvider instanceof WorldProviderEnd) {
			File file2 = new File(file, "DIM1");
			file2.mkdirs();
			return new AnvilChunkLoader(file2);
		} else {
			return new AnvilChunkLoader(file);
		}
	}

	/**
	 * saves level.dat and backs up the existing one to level.dat_old
	 */
	public void saveWorldInfoAndPlayer(WorldInfo par1WorldInfo, List par2List) {
		par1WorldInfo.setSaveVersion(19133);
		super.saveWorldInfoAndPlayer(par1WorldInfo, par2List);
	}
}
