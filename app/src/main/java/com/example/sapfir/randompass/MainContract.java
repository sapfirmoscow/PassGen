package com.example.sapfir.randompass;

public interface MainContract {

    interface View {
        /**
         * @param message for password
         */
        void showText(String message);
    }

    interface Presenter {
        void onButtonWasClicked();

        void onDestroy();
    }

    interface Repository {
        String loadMessage();
    }

}
