package sample;

import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.util.Duration;

public class Animate_Form {
    private ScaleTransition st;

    public Animate_Form (Node node) {
        st = new ScaleTransition(Duration.millis(100), node);
        st.setByX(0.5f);
        st.setByY(0.5f);
        st.setCycleCount(2);
        st.setAutoReverse(true);
        //st.play();

    }

    public void play_animate() {
        st.play();
    }
}
