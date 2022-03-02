package cz.bakterio.discord.Tux;

import net.dv8tion.jda.api.entities.Activity;

public class ActivitySwitcher {
    private static String[] activities = new String[] {
            "Linus is noob",
            "FOSS!!!",
            "C# on linux, aaaaaaah :(",
            "Electron apps, what a bloatware!!!",
            "Linus Torvalds is our god"
    };

    public static void startSwitcher() {
        Thread th = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    for (int i = 0; i < activities.length; i++) {
                        try {
                            String activity = activities[i];
                            Tux.jda.getPresence().setPresence(Activity.watching(activity), false);
                            System.out.println("Activity has been changed to '" + activity + "'.");
                            Thread.sleep(4000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        th.run();
    }
}