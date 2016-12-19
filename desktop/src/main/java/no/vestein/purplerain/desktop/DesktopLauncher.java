package no.vestein.purplerain.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import no.vestein.purplerain.PurpleRain$;
import no.vestein.purplerain.Reference;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = Reference.WIDTH();
		config.height = Reference.HEIGHT();
		config.samples = 0;
		new LwjglApplication(PurpleRain$.MODULE$, config);
	}
}
