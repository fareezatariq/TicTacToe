package com.example.tictactoe;

import static androidx.core.content.ContextCompat.startActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class WinDialog extends Dialog {
    private final String message;
    private final gameMechanics GameMechanics;
public WinDialog(@NonNull Context context, String message, gameMechanics GameMechanics){
    super(context);
    this.message=message;
    this.GameMechanics=GameMechanics;

}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.win_dialog_layout);

        final TextView messageTxt= findViewById(R.id.messageText);
        final Button startAgainBtn= findViewById(R.id.startAgain);
        final Button newGame= findViewById(R.id.newGame);

        messageTxt.setText(message);

        startAgainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GameMechanics.reStartMatch();
                dismiss();
            }
        });
        newGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                Intent intent = new Intent(getContext(), AddPlayers.class);
                startActivity(getContext(), intent, null);
            }
        });
    }
}
