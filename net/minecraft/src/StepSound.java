package net.minecraft.src;

public class StepSound {
	public final String stepSoundName;
	public final float stepSoundVolume;
	public final float stepSoundPitch;

	public StepSound(String par1Str, float par2, float par3) {
		stepSoundName = par1Str;
		stepSoundVolume = par2;
		stepSoundPitch = par3;
	}

	public float getVolume() {
		return stepSoundVolume;
	}

	public float getPitch() {
		return stepSoundPitch;
	}

	/**
	 * Used when a block breaks, EXA: Player break, Shep eating grass, etc..
	 */
	public String getBreakSound() {
		return (new StringBuilder()).append("step.").append(stepSoundName)
				.toString();
	}

	/**
	 * Used when a entity walks over, or otherwise interacts with the block.
	 */
	public String getStepSound() {
		return (new StringBuilder()).append("step.").append(stepSoundName)
				.toString();
	}
}
