package gms.adx.monetize;

import static androidx.lifecycle.Lifecycle.Event.ON_START;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ProcessLifecycleOwner;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.appopen.AppOpenAd;


public class AppOpenManager_New implements Application.ActivityLifecycleCallbacks, LifecycleObserver {
    private static boolean isShowingAd = false;
    private final Application myApplication;
    String App_Open_ID = "";
    int Check = 1;
    String AC1 = "", AC2 = "", AC3 = "", AC4 = "", AC5 = "";
    private AppOpenAd appOpenAd = null;
    private Activity currentActivity;
    private AppOpenAd.AppOpenAdLoadCallback loadCallback;


    public AppOpenManager_New(Application myApplication, String Ac1, String Ac2, String Ac3, String Ac4, String Ac5) {
        this.myApplication = myApplication;

        this.AC1 = Ac1;
        this.AC2 = Ac2;
        this.AC3 = Ac3;
        this.AC4 = Ac4;
        this.AC5 = Ac5;

        this.myApplication.registerActivityLifecycleCallbacks(this);
        ProcessLifecycleOwner.get().getLifecycle().addObserver(this);


    }


    public void showAdIfAvailable() {

        if (!isShowingAd && isAdAvailable()) {

            FullScreenContentCallback fullScreenContentCallback =
                    new FullScreenContentCallback() {
                        @Override
                        public void onAdDismissedFullScreenContent() {
                            AppOpenManager_New.this.appOpenAd = null;
                            isShowingAd = false;

                            if ((SharedPreferences.getSetup(myApplication)).equals("1") ||
                                    (SharedPreferences.getSetup(myApplication)).equals("2") ||
                                    (SharedPreferences.getSetup(myApplication)).equals("3") ||
                                    (SharedPreferences.getSetup(myApplication)).equals("4") ||
                                    (SharedPreferences.getSetup(myApplication)).equals("5") ||
                                    (SharedPreferences.getSetup(myApplication)).equals("6") ||
                                    (SharedPreferences.getSetup(myApplication)).equals("7") ||
                                    (SharedPreferences.getSetup(myApplication)).equals("8") ||
                                    (SharedPreferences.getSetup(myApplication)).equals("9") ||
                                    (SharedPreferences.getSetup(myApplication)).equals("10")) {

                                Check = 1;
                                fetchAd();

                            } else if ((SharedPreferences.getSetup(myApplication)).equals("0")) {

                                Check = 0;
                                fetchAd();

                            }


                        }

                        @Override
                        public void onAdFailedToShowFullScreenContent(AdError adError) {
                        }

                        @Override
                        public void onAdShowedFullScreenContent() {
                            isShowingAd = true;
                        }
                    };

            appOpenAd.show(currentActivity, fullScreenContentCallback);

        } else {

            if ((SharedPreferences.getSetup(myApplication)).equals("1") ||
                    (SharedPreferences.getSetup(myApplication)).equals("2") ||
                    (SharedPreferences.getSetup(myApplication)).equals("3") ||
                    (SharedPreferences.getSetup(myApplication)).equals("4") ||
                    (SharedPreferences.getSetup(myApplication)).equals("5") ||
                    (SharedPreferences.getSetup(myApplication)).equals("6") ||
                    (SharedPreferences.getSetup(myApplication)).equals("7") ||
                    (SharedPreferences.getSetup(myApplication)).equals("8") ||
                    (SharedPreferences.getSetup(myApplication)).equals("9") ||
                    (SharedPreferences.getSetup(myApplication)).equals("10")) {

                Check = 1;
                fetchAd();

            } else if ((SharedPreferences.getSetup(myApplication)).equals("0")) {

                Check = 0;
                fetchAd();

            }

        }
    }


    public void fetchAd() {

        if (Gotas.Exit_Menu_Decided == 100) {

            return;
        }

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                if (Gotas.Server_Yes_No == 1 || Gotas.Server_Yes_No == 0) {

                    if (isAdAvailable()) {
                        return;
                    }

                    if ((SharedPreferences.getSetup(myApplication)).equals("1") ||
                            (SharedPreferences.getSetup(myApplication)).equals("2") ||
                            (SharedPreferences.getSetup(myApplication)).equals("3") ||
                            (SharedPreferences.getSetup(myApplication)).equals("4") ||
                            (SharedPreferences.getSetup(myApplication)).equals("5") ||
                            (SharedPreferences.getSetup(myApplication)).equals("6") ||
                            (SharedPreferences.getSetup(myApplication)).equals("7") ||
                            (SharedPreferences.getSetup(myApplication)).equals("8") ||
                            (SharedPreferences.getSetup(myApplication)).equals("9") ||
                            (SharedPreferences.getSetup(myApplication)).equals("10")) {


                        if ((SharedPreferences.getSetup(myApplication)).equals("1")) {

                            if (Check == 1) {

                                if (SharedPreferences.getAOAO1_AO(myApplication) == 0) {

                                    App_Open_ID = SharedPreferences.getAO11(myApplication);

                                    SharedPreferences.setAOAO1_AO(myApplication, 1);

                                } else {

                                    App_Open_ID = SharedPreferences.getAO111(myApplication);

                                    SharedPreferences.setAOAO1_AO(myApplication, 0);

                                }

                            } else if (Check == 2) {


                                if (SharedPreferences.getAOAO2_AO(myApplication) == 0) {

                                    App_Open_ID = SharedPreferences.getAO22(myApplication);

                                    SharedPreferences.setAOAO2_AO(myApplication, 1);

                                } else {

                                    App_Open_ID = SharedPreferences.getAO222(myApplication);

                                    SharedPreferences.setAOAO2_AO(myApplication, 0);

                                }

                            } else if (Check == 3) {

                                if (SharedPreferences.getAOAO3_AO(myApplication) == 0) {

                                    App_Open_ID = SharedPreferences.getAO33(myApplication);

                                    SharedPreferences.setAOAO3_AO(myApplication, 1);

                                } else {

                                    App_Open_ID = SharedPreferences.getAO333(myApplication);

                                    SharedPreferences.setAOAO3_AO(myApplication, 0);

                                }

                                Check = 0;

                            }

                        }
                        if ((SharedPreferences.getSetup(myApplication)).equals("2")) {

                            if (Check == 1) {

                                if (SharedPreferences.getAOAO1_AO(myApplication) == 0) {

                                    App_Open_ID = SharedPreferences.getAO11(myApplication);

                                    SharedPreferences.setAOAO1_AO(myApplication, 1);

                                } else {

                                    App_Open_ID = SharedPreferences.getAO111(myApplication);

                                    SharedPreferences.setAOAO1_AO(myApplication, 0);

                                }

                            } else if (Check == 2) {

                                if (SharedPreferences.getAOAO1_AO(myApplication) == 0) {

                                    App_Open_ID = SharedPreferences.getAO11(myApplication);

                                    SharedPreferences.setAOAO1_AO(myApplication, 1);

                                } else {

                                    App_Open_ID = SharedPreferences.getAO111(myApplication);

                                    SharedPreferences.setAOAO1_AO(myApplication, 0);

                                }

                            } else if (Check == 3) {


                                if (SharedPreferences.getAOAO2_AO(myApplication) == 0) {

                                    App_Open_ID = SharedPreferences.getAO22(myApplication);

                                    SharedPreferences.setAOAO2_AO(myApplication, 1);

                                } else {

                                    App_Open_ID = SharedPreferences.getAO222(myApplication);

                                    SharedPreferences.setAOAO2_AO(myApplication, 0);

                                }

                            } else if (Check == 4) {

                                if (SharedPreferences.getAOAO3_AO(myApplication) == 0) {

                                    App_Open_ID = SharedPreferences.getAO33(myApplication);

                                    SharedPreferences.setAOAO3_AO(myApplication, 1);

                                } else {

                                    App_Open_ID = SharedPreferences.getAO333(myApplication);

                                    SharedPreferences.setAOAO3_AO(myApplication, 0);

                                }

                                Check = 0;

                            }

                        }
                        if ((SharedPreferences.getSetup(myApplication)).equals("3")) {

                            if (Check == 1) {

                                if (SharedPreferences.getAOAO1_AO(myApplication) == 0) {

                                    App_Open_ID = SharedPreferences.getAO11(myApplication);

                                    SharedPreferences.setAOAO1_AO(myApplication, 1);

                                } else {

                                    App_Open_ID = SharedPreferences.getAO111(myApplication);

                                    SharedPreferences.setAOAO1_AO(myApplication, 0);

                                }

                            } else if (Check == 2) {

                                if (SharedPreferences.getAOAO1_AO(myApplication) == 0) {

                                    App_Open_ID = SharedPreferences.getAO11(myApplication);

                                    SharedPreferences.setAOAO1_AO(myApplication, 1);

                                } else {

                                    App_Open_ID = SharedPreferences.getAO111(myApplication);

                                    SharedPreferences.setAOAO1_AO(myApplication, 0);

                                }

                            } else if (Check == 3) {

                                if (SharedPreferences.getAOAO1_AO(myApplication) == 0) {

                                    App_Open_ID = SharedPreferences.getAO11(myApplication);

                                    SharedPreferences.setAOAO1_AO(myApplication, 1);

                                } else {

                                    App_Open_ID = SharedPreferences.getAO111(myApplication);

                                    SharedPreferences.setAOAO1_AO(myApplication, 0);

                                }

                            } else if (Check == 4) {


                                if (SharedPreferences.getAOAO2_AO(myApplication) == 0) {

                                    App_Open_ID = SharedPreferences.getAO22(myApplication);

                                    SharedPreferences.setAOAO2_AO(myApplication, 1);

                                } else {

                                    App_Open_ID = SharedPreferences.getAO222(myApplication);

                                    SharedPreferences.setAOAO2_AO(myApplication, 0);

                                }

                            } else if (Check == 5) {

                                if (SharedPreferences.getAOAO3_AO(myApplication) == 0) {

                                    App_Open_ID = SharedPreferences.getAO33(myApplication);

                                    SharedPreferences.setAOAO3_AO(myApplication, 1);

                                } else {

                                    App_Open_ID = SharedPreferences.getAO333(myApplication);

                                    SharedPreferences.setAOAO3_AO(myApplication, 0);

                                }

                                Check = 0;

                            }

                        }
                        if ((SharedPreferences.getSetup(myApplication)).equals("4")) {

                            if (Check == 1) {

                                if (SharedPreferences.getAOAO1_AO(myApplication) == 0) {

                                    App_Open_ID = SharedPreferences.getAO11(myApplication);

                                    SharedPreferences.setAOAO1_AO(myApplication, 1);

                                } else {

                                    App_Open_ID = SharedPreferences.getAO111(myApplication);

                                    SharedPreferences.setAOAO1_AO(myApplication, 0);

                                }

                            } else if (Check == 2) {

                                if (SharedPreferences.getAOAO1_AO(myApplication) == 0) {

                                    App_Open_ID = SharedPreferences.getAO11(myApplication);

                                    SharedPreferences.setAOAO1_AO(myApplication, 1);

                                } else {

                                    App_Open_ID = SharedPreferences.getAO111(myApplication);

                                    SharedPreferences.setAOAO1_AO(myApplication, 0);

                                }

                            } else if (Check == 3) {

                                if (SharedPreferences.getAOAO1_AO(myApplication) == 0) {

                                    App_Open_ID = SharedPreferences.getAO11(myApplication);

                                    SharedPreferences.setAOAO1_AO(myApplication, 1);

                                } else {

                                    App_Open_ID = SharedPreferences.getAO111(myApplication);

                                    SharedPreferences.setAOAO1_AO(myApplication, 0);

                                }

                            } else if (Check == 4) {

                                if (SharedPreferences.getAOAO1_AO(myApplication) == 0) {

                                    App_Open_ID = SharedPreferences.getAO11(myApplication);

                                    SharedPreferences.setAOAO1_AO(myApplication, 1);

                                } else {

                                    App_Open_ID = SharedPreferences.getAO111(myApplication);

                                    SharedPreferences.setAOAO1_AO(myApplication, 0);

                                }

                            } else if (Check == 5) {


                                if (SharedPreferences.getAOAO2_AO(myApplication) == 0) {

                                    App_Open_ID = SharedPreferences.getAO22(myApplication);

                                    SharedPreferences.setAOAO2_AO(myApplication, 1);

                                } else {

                                    App_Open_ID = SharedPreferences.getAO222(myApplication);

                                    SharedPreferences.setAOAO2_AO(myApplication, 0);

                                }

                            } else if (Check == 6) {

                                if (SharedPreferences.getAOAO3_AO(myApplication) == 0) {

                                    App_Open_ID = SharedPreferences.getAO33(myApplication);

                                    SharedPreferences.setAOAO3_AO(myApplication, 1);

                                } else {

                                    App_Open_ID = SharedPreferences.getAO333(myApplication);

                                    SharedPreferences.setAOAO3_AO(myApplication, 0);

                                }

                                Check = 0;

                            }

                        }
                        if ((SharedPreferences.getSetup(myApplication)).equals("5")) {

                            if (Check == 1) {

                                if (SharedPreferences.getAOAO1_AO(myApplication) == 0) {

                                    App_Open_ID = SharedPreferences.getAO11(myApplication);

                                    SharedPreferences.setAOAO1_AO(myApplication, 1);

                                } else {

                                    App_Open_ID = SharedPreferences.getAO111(myApplication);

                                    SharedPreferences.setAOAO1_AO(myApplication, 0);

                                }

                            } else if (Check == 2) {

                                if (SharedPreferences.getAOAO1_AO(myApplication) == 0) {

                                    App_Open_ID = SharedPreferences.getAO11(myApplication);

                                    SharedPreferences.setAOAO1_AO(myApplication, 1);

                                } else {

                                    App_Open_ID = SharedPreferences.getAO111(myApplication);

                                    SharedPreferences.setAOAO1_AO(myApplication, 0);

                                }

                            } else if (Check == 3) {

                                if (SharedPreferences.getAOAO1_AO(myApplication) == 0) {

                                    App_Open_ID = SharedPreferences.getAO11(myApplication);

                                    SharedPreferences.setAOAO1_AO(myApplication, 1);

                                } else {

                                    App_Open_ID = SharedPreferences.getAO111(myApplication);

                                    SharedPreferences.setAOAO1_AO(myApplication, 0);

                                }

                            } else if (Check == 4) {

                                if (SharedPreferences.getAOAO1_AO(myApplication) == 0) {

                                    App_Open_ID = SharedPreferences.getAO11(myApplication);

                                    SharedPreferences.setAOAO1_AO(myApplication, 1);

                                } else {

                                    App_Open_ID = SharedPreferences.getAO111(myApplication);

                                    SharedPreferences.setAOAO1_AO(myApplication, 0);

                                }

                            } else if (Check == 5) {

                                if (SharedPreferences.getAOAO1_AO(myApplication) == 0) {

                                    App_Open_ID = SharedPreferences.getAO11(myApplication);

                                    SharedPreferences.setAOAO1_AO(myApplication, 1);

                                } else {

                                    App_Open_ID = SharedPreferences.getAO111(myApplication);

                                    SharedPreferences.setAOAO1_AO(myApplication, 0);

                                }

                            } else if (Check == 6) {


                                if (SharedPreferences.getAOAO2_AO(myApplication) == 0) {

                                    App_Open_ID = SharedPreferences.getAO22(myApplication);

                                    SharedPreferences.setAOAO2_AO(myApplication, 1);

                                } else {

                                    App_Open_ID = SharedPreferences.getAO222(myApplication);

                                    SharedPreferences.setAOAO2_AO(myApplication, 0);

                                }

                            } else if (Check == 7) {

                                if (SharedPreferences.getAOAO3_AO(myApplication) == 0) {

                                    App_Open_ID = SharedPreferences.getAO33(myApplication);

                                    SharedPreferences.setAOAO3_AO(myApplication, 1);

                                } else {

                                    App_Open_ID = SharedPreferences.getAO333(myApplication);

                                    SharedPreferences.setAOAO3_AO(myApplication, 0);

                                }

                                Check = 0;

                            }

                        }
                        if ((SharedPreferences.getSetup(myApplication)).equals("6")) {

                            if (Check == 1) {

                                if (SharedPreferences.getAOAO1_AO(myApplication) == 0) {

                                    App_Open_ID = SharedPreferences.getAO11(myApplication);

                                    SharedPreferences.setAOAO1_AO(myApplication, 1);

                                } else {

                                    App_Open_ID = SharedPreferences.getAO111(myApplication);

                                    SharedPreferences.setAOAO1_AO(myApplication, 0);

                                }

                            } else if (Check == 2) {


                                if (SharedPreferences.getAOAO2_AO(myApplication) == 0) {

                                    App_Open_ID = SharedPreferences.getAO22(myApplication);

                                    SharedPreferences.setAOAO2_AO(myApplication, 1);

                                } else {

                                    App_Open_ID = SharedPreferences.getAO222(myApplication);

                                    SharedPreferences.setAOAO2_AO(myApplication, 0);

                                }

                            } else if (Check == 3) {


                                if (SharedPreferences.getAOAO2_AO(myApplication) == 0) {

                                    App_Open_ID = SharedPreferences.getAO22(myApplication);

                                    SharedPreferences.setAOAO2_AO(myApplication, 1);

                                } else {

                                    App_Open_ID = SharedPreferences.getAO222(myApplication);

                                    SharedPreferences.setAOAO2_AO(myApplication, 0);

                                }

                            } else if (Check == 4) {

                                if (SharedPreferences.getAOAO3_AO(myApplication) == 0) {

                                    App_Open_ID = SharedPreferences.getAO33(myApplication);

                                    SharedPreferences.setAOAO3_AO(myApplication, 1);

                                } else {

                                    App_Open_ID = SharedPreferences.getAO333(myApplication);

                                    SharedPreferences.setAOAO3_AO(myApplication, 0);

                                }

                                Check = 0;

                            }

                        }
                        if ((SharedPreferences.getSetup(myApplication)).equals("7")) {

                            if (Check == 1) {

                                if (SharedPreferences.getAOAO1_AO(myApplication) == 0) {

                                    App_Open_ID = SharedPreferences.getAO11(myApplication);

                                    SharedPreferences.setAOAO1_AO(myApplication, 1);

                                } else {

                                    App_Open_ID = SharedPreferences.getAO111(myApplication);

                                    SharedPreferences.setAOAO1_AO(myApplication, 0);

                                }

                            } else if (Check == 2) {

                                if (SharedPreferences.getAOAO1_AO(myApplication) == 0) {

                                    App_Open_ID = SharedPreferences.getAO11(myApplication);

                                    SharedPreferences.setAOAO1_AO(myApplication, 1);

                                } else {

                                    App_Open_ID = SharedPreferences.getAO111(myApplication);

                                    SharedPreferences.setAOAO1_AO(myApplication, 0);

                                }

                            } else if (Check == 3) {


                                if (SharedPreferences.getAOAO2_AO(myApplication) == 0) {

                                    App_Open_ID = SharedPreferences.getAO22(myApplication);

                                    SharedPreferences.setAOAO2_AO(myApplication, 1);

                                } else {

                                    App_Open_ID = SharedPreferences.getAO222(myApplication);

                                    SharedPreferences.setAOAO2_AO(myApplication, 0);

                                }

                            } else if (Check == 4) {


                                if (SharedPreferences.getAOAO2_AO(myApplication) == 0) {

                                    App_Open_ID = SharedPreferences.getAO22(myApplication);

                                    SharedPreferences.setAOAO2_AO(myApplication, 1);

                                } else {

                                    App_Open_ID = SharedPreferences.getAO222(myApplication);

                                    SharedPreferences.setAOAO2_AO(myApplication, 0);

                                }

                            } else if (Check == 5) {

                                if (SharedPreferences.getAOAO3_AO(myApplication) == 0) {

                                    App_Open_ID = SharedPreferences.getAO33(myApplication);

                                    SharedPreferences.setAOAO3_AO(myApplication, 1);

                                } else {

                                    App_Open_ID = SharedPreferences.getAO333(myApplication);

                                    SharedPreferences.setAOAO3_AO(myApplication, 0);

                                }

                                Check = 0;

                            }

                        }
                        if ((SharedPreferences.getSetup(myApplication)).equals("8")) {

                            if (Check == 1) {

                                if (SharedPreferences.getAOAO1_AO(myApplication) == 0) {

                                    App_Open_ID = SharedPreferences.getAO11(myApplication);

                                    SharedPreferences.setAOAO1_AO(myApplication, 1);

                                } else {

                                    App_Open_ID = SharedPreferences.getAO111(myApplication);

                                    SharedPreferences.setAOAO1_AO(myApplication, 0);

                                }

                            } else if (Check == 2) {

                                if (SharedPreferences.getAOAO1_AO(myApplication) == 0) {

                                    App_Open_ID = SharedPreferences.getAO11(myApplication);

                                    SharedPreferences.setAOAO1_AO(myApplication, 1);

                                } else {

                                    App_Open_ID = SharedPreferences.getAO111(myApplication);

                                    SharedPreferences.setAOAO1_AO(myApplication, 0);

                                }

                            } else if (Check == 3) {

                                if (SharedPreferences.getAOAO1_AO(myApplication) == 0) {

                                    App_Open_ID = SharedPreferences.getAO11(myApplication);

                                    SharedPreferences.setAOAO1_AO(myApplication, 1);

                                } else {

                                    App_Open_ID = SharedPreferences.getAO111(myApplication);

                                    SharedPreferences.setAOAO1_AO(myApplication, 0);

                                }

                            } else if (Check == 4) {


                                if (SharedPreferences.getAOAO2_AO(myApplication) == 0) {

                                    App_Open_ID = SharedPreferences.getAO22(myApplication);

                                    SharedPreferences.setAOAO2_AO(myApplication, 1);

                                } else {

                                    App_Open_ID = SharedPreferences.getAO222(myApplication);

                                    SharedPreferences.setAOAO2_AO(myApplication, 0);

                                }

                            } else if (Check == 5) {


                                if (SharedPreferences.getAOAO2_AO(myApplication) == 0) {

                                    App_Open_ID = SharedPreferences.getAO22(myApplication);

                                    SharedPreferences.setAOAO2_AO(myApplication, 1);

                                } else {

                                    App_Open_ID = SharedPreferences.getAO222(myApplication);

                                    SharedPreferences.setAOAO2_AO(myApplication, 0);

                                }

                            } else if (Check == 6) {

                                if (SharedPreferences.getAOAO3_AO(myApplication) == 0) {

                                    App_Open_ID = SharedPreferences.getAO33(myApplication);

                                    SharedPreferences.setAOAO3_AO(myApplication, 1);

                                } else {

                                    App_Open_ID = SharedPreferences.getAO333(myApplication);

                                    SharedPreferences.setAOAO3_AO(myApplication, 0);

                                }

                                Check = 0;

                            }

                        }


                    } else if ((SharedPreferences.getSetup(myApplication)).equals("0")) {

                        if (Check == 0) {
                            App_Open_ID = SharedPreferences.getapp_open(myApplication);
                        }

                    }

                    loadCallback =
                            new AppOpenAd.AppOpenAdLoadCallback() {

                                @Override
                                public void onAppOpenAdLoaded(AppOpenAd ad) {

                                    if ((SharedPreferences.getSetup(myApplication)).equals("1") ||
                                            (SharedPreferences.getSetup(myApplication)).equals("2") ||
                                            (SharedPreferences.getSetup(myApplication)).equals("3") ||
                                            (SharedPreferences.getSetup(myApplication)).equals("4") ||
                                            (SharedPreferences.getSetup(myApplication)).equals("5") ||
                                            (SharedPreferences.getSetup(myApplication)).equals("6") ||
                                            (SharedPreferences.getSetup(myApplication)).equals("7") ||
                                            (SharedPreferences.getSetup(myApplication)).equals("8") ||
                                            (SharedPreferences.getSetup(myApplication)).equals("9") ||
                                            (SharedPreferences.getSetup(myApplication)).equals("10")) {
                                        Check = 1;
                                    } else if ((SharedPreferences.getSetup(myApplication)).equals("0")) {
                                        Check = 0;
                                    }

                                    AppOpenManager_New.this.appOpenAd = ad;
                                }


                                @Override
                                public void onAppOpenAdFailedToLoad(LoadAdError loadAdError) {

                                    if ((SharedPreferences.getSetup(myApplication)).equals("1") ||
                                            (SharedPreferences.getSetup(myApplication)).equals("2") ||
                                            (SharedPreferences.getSetup(myApplication)).equals("3") ||
                                            (SharedPreferences.getSetup(myApplication)).equals("4") ||
                                            (SharedPreferences.getSetup(myApplication)).equals("5") ||
                                            (SharedPreferences.getSetup(myApplication)).equals("6") ||
                                            (SharedPreferences.getSetup(myApplication)).equals("7") ||
                                            (SharedPreferences.getSetup(myApplication)).equals("8") ||
                                            (SharedPreferences.getSetup(myApplication)).equals("9") ||
                                            (SharedPreferences.getSetup(myApplication)).equals("10")) {
                                        Check = Check + 1;
                                        fetchAd();
                                    } else if ((SharedPreferences.getSetup(myApplication)).equals("0")) {
                                        Check = 0;
                                        fetchAd();
                                    }

                                }


                            };
                    AdRequest request = getAdRequest();
                    AppOpenAd.load(
                            myApplication, App_Open_ID, request,
                            AppOpenAd.APP_OPEN_AD_ORIENTATION_PORTRAIT, loadCallback);

                } else {

                    handler.postDelayed(this, 500);

                }

            }

        }, 500);


    }


    private AdRequest getAdRequest() {
        return new AdRequest.Builder().build();
    }


    public boolean isAdAvailable() {
        return appOpenAd != null;
    }


    @OnLifecycleEvent(ON_START)
    public void onStart() {
        if ((currentActivity.getLocalClassName()).equals(AC1) ||
                (currentActivity.getLocalClassName()).equals(AC2) ||
                (currentActivity.getLocalClassName()).equals(AC3) ||
                (currentActivity.getLocalClassName()).equals(AC4) ||
                (currentActivity.getLocalClassName()).equals(AC5)) {


        } else {
            showAdIfAvailable();
        }
    }


    @Override
    public void onActivityPreCreated(@NonNull Activity activity, @Nullable Bundle savedInstanceState) {

    }

    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
    }

    @Override
    public void onActivityStarted(Activity activity) {
        currentActivity = activity;
    }

    @Override
    public void onActivityResumed(Activity activity) {
        currentActivity = activity;
    }

    @Override
    public void onActivityStopped(Activity activity) {
    }

    @Override
    public void onActivityPaused(Activity activity) {
    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override
    public void onActivityDestroyed(Activity activity) {
        currentActivity = null;
    }

}

