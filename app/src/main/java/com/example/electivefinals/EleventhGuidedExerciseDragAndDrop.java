package com.example.electivefinals;

import android.content.ClipData;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class EleventhGuidedExerciseDragAndDrop extends AppCompatActivity implements View.OnLongClickListener {

    ImageView batman, superman, ironman, wolverine, dropHere;
    TextView status, heroName;
    ConstraintLayout constraintLayout;
    ClipData clipData;
    String imageName;
    Animation animateImage, animateText;
    Drawable drawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eleventh_guided_exercise_drag_and_drop);

        init();

        dropHere.setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View view, DragEvent dragEvent) {
                final View v = (View) dragEvent.getLocalState();
                int state = dragEvent.getAction();
                imageName = clipData.getDescription().getLabel().toString();
                int id = getResources().getIdentifier(imageName, "drawable", getPackageName());

                switch (state) {
                    case DragEvent.ACTION_DRAG_STARTED:
                        status.setText("ACTION_DRAG_STARTED");
                        heroName.setText("DRAG AND DROP YOUR HERO HERE!");
                        dropHere.setImageResource(R.drawable.hero);
                        dropHere.startAnimation(animateImage);
                        break;
                    case DragEvent.ACTION_DROP:
                        status.setText("ACTION_DROP");
                        heroName.setText("DRAG AND DROP YOUR HERO HERE!");
                        dropHere.setImageDrawable(drawable);
                        break;
                    case DragEvent.ACTION_DRAG_ENTERED:
                        status.setText("ACTION_DRAG_ENTERED");
                        drawable = getResources().getDrawable(id);
                        dropHere.setImageDrawable(drawable);
                        dropHere.startAnimation(animateImage);
                        heroName.setText(imageName);
                        heroName.startAnimation(animateText);
                        break;
                    case DragEvent.ACTION_DRAG_EXITED:
                        status.setText("ACTION_DRAG_EXITED");
                        dropHere.setImageResource(R.drawable.hero);
                        heroName.clearAnimation();
                        break;
                    case DragEvent.ACTION_DRAG_ENDED:
                        status.setText("ACTION_DRAG_ENDED");
                        constraintLayout.removeView(v);
                        v.setVisibility(View.VISIBLE);
                        constraintLayout.addView(v);
                        dropHere.clearAnimation();
                        heroName.clearAnimation();
                        break;
                }
                return true;
            }
        });
    }

    public void init() {
        animateText = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.my_animation);
        animateImage = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink);
        batman = findViewById(R.id.ivBatman);
        superman = findViewById(R.id.ivSuperman);
        wolverine = findViewById(R.id.ivWolverine);
        ironman = findViewById(R.id.ivIronman);
        dropHere = findViewById(R.id.ivHero);
        status = findViewById(R.id.tvStatus);
        heroName = findViewById(R.id.tvNameOfHero);
        constraintLayout = findViewById(R.id.clDragNDrop);

        batman.setOnLongClickListener(this);
        superman.setOnLongClickListener(this);
        ironman.setOnLongClickListener(this);
        wolverine.setOnLongClickListener(this);
    }

    @Override
    public boolean onLongClick(View view) {
        view.setVisibility(View.INVISIBLE);
        View.DragShadowBuilder dragShadowBuilder = new View.DragShadowBuilder(view);
        clipData = ClipData.newPlainText(view.getTag().toString(), null);
        view.startDrag(clipData, dragShadowBuilder, view, 0);
        return true;
    }
}
