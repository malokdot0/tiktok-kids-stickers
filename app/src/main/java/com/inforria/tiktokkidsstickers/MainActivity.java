package com.inforria.tiktokkidsstickers;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.content.Intent;
import android.net.Uri;

public class MainActivity extends Activity {
    final int green = Color.rgb(18,140,126);
    @Override public void onCreate(Bundle b) {
        super.onCreate(b);
        getWindow().setStatusBarColor(Color.rgb(7,94,84));
        LinearLayout page = new LinearLayout(this);
        page.setOrientation(LinearLayout.VERTICAL);
        page.setPadding(20,26,20,18);
        page.setBackgroundColor(Color.rgb(247,249,250));
        TextView title = new TextView(this);
        title.setText("TikTok Kids Stickers");
        title.setTextSize(27); title.setTypeface(null, Typeface.BOLD);
        title.setTextColor(Color.rgb(7,94,84)); page.addView(title);
        TextView sub = new TextView(this);
        sub.setText("Cute reactions • Babies • Kids • WhatsApp");
        sub.setTextSize(15); sub.setTextColor(Color.DKGRAY);
        sub.setPadding(0,8,0,16); page.addView(sub);
        ScrollView scroll = new ScrollView(this);
        LinearLayout content = new LinearLayout(this);
        content.setOrientation(LinearLayout.VERTICAL);
        String[][] rows = {
          {"😊 Happy","😂 LOL","😍 Love"},
          {"😢 Sad","😡 Angry","😮 Wow!"},
          {"😴 Sleepy","😎 Cool","😘 Kiss"},
          {"🥹 Thanks","🤗 Hug","🙏 Please"},
          {"👋 Bye!","🎉 Yay!","🤔 Hmm..."},
          {"🥰 Cute","😱 OMG!","👍 Good!"},
          {"🤫 Shhh","🍕 Yum!","💖 Love"}
        };
        for (String[] rowData : rows) {
            LinearLayout row = new LinearLayout(this);
            row.setOrientation(LinearLayout.HORIZONTAL);
            for (String label : rowData) {
                TextView tile = new TextView(this);
                tile.setText(label); tile.setTextSize(16);
                tile.setGravity(Gravity.CENTER);
                tile.setTextColor(Color.rgb(45,55,65));
                tile.setBackgroundColor(Color.WHITE);
                tile.setPadding(5,20,5,20);
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(0,-2,1);
                lp.setMargins(4,4,4,4); row.addView(tile,lp);
            }
            content.addView(row);
        }
        scroll.addView(content);
        page.addView(scroll,new LinearLayout.LayoutParams(-1,0,1));
        Button open = new Button(this);
        open.setText("Open WhatsApp");
        open.setTextColor(Color.WHITE);
        open.setBackgroundTintList(android.content.res.ColorStateList.valueOf(green));
        open.setOnClickListener(v -> {
            Intent i = getPackageManager().getLaunchIntentForPackage("com.whatsapp");
            if (i != null) startActivity(i);
            else startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.whatsapp")));
        });
        page.addView(open);
        TextView note = new TextView(this);
        note.setText("Preview version: stickers are display examples. WhatsApp sticker import is not yet implemented.");
        note.setTextColor(Color.GRAY); note.setTextSize(12); note.setPadding(0,10,0,0);
        page.addView(note);
        setContentView(page);
    }
}
