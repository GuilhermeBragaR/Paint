package br.com.progiv.paint;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

import com.mukesh.DrawingView;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {
    private Button /*saveButton,*/ penButton, eraserButton, penColorButtonVerde,penColorButtonAzul,
    penColorButtonVermelho,penColorButtonPreto, clearButton;
    private DrawingView drawingView;
    private SeekBar penSizeSeekBar, eraserSizeSeekBar;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeUI();
        setListeners();
    }

    private void setListeners() {
        /*saveButton.setOnClickListener(this);*/
        penButton.setOnClickListener(this);
        eraserButton.setOnClickListener(this);
        penColorButtonVerde.setOnClickListener(this);
        penColorButtonAzul.setOnClickListener(this);
        penColorButtonPreto.setOnClickListener(this);
        penColorButtonVermelho.setOnClickListener(this);
        penSizeSeekBar.setOnSeekBarChangeListener(this);
        eraserSizeSeekBar.setOnSeekBarChangeListener(this);
        clearButton.setOnClickListener(this);
    }

    private void initializeUI() {
        drawingView = findViewById(R.id.scratch_pad);
        //saveButton = findViewById(R.id.save_button);
        penButton = findViewById(R.id.pen_button);
        eraserButton = findViewById(R.id.eraser_button);
        penColorButtonVerde = findViewById(R.id.pen_color_button_verde);
        penColorButtonVermelho = findViewById(R.id.pen_color_button_vermelho);
        penColorButtonAzul = findViewById(R.id.pen_color_button_azul);
        penColorButtonPreto = findViewById(R.id.pen_color_button_preto);
        penSizeSeekBar = findViewById(R.id.pen_size_seekbar);
        eraserSizeSeekBar = findViewById(R.id.eraser_size_seekbar);
        clearButton = findViewById(R.id.clear_button);
    }

    @Override public void onClick(View view) {
        switch (view.getId()) {
            /*case R.id.save_button:
                drawingView.saveImage(Environment.getExternalStorageDirectory().toString(), "test",
                        Bitmap.CompressFormat.PNG, 100);
                break;*/
            case R.id.pen_button:
                drawingView.initializePen();
                break;
            case R.id.eraser_button:
                drawingView.initializeEraser();
                break;
            case R.id.clear_button:
                drawingView.clear();
                break;
            case R.id.pen_color_button_verde:
                drawingView.setPenColor(Color.GREEN);
                /*final ColorPicker colorPicker = new ColorPicker(MainActivity.this, 100, 100, 100);
                colorPicker.setCallback(
                        new ColorPickerCallback() {
                            @Override public void onColorChosen(int color) {
                                drawingView.setPenColor(color);
                                colorPicker.dismiss();
                            }
                        });
                colorPicker.show();*/
                break;
            case R.id.pen_color_button_azul:
                drawingView.setPenColor(Color.BLUE);
                break;
            case R.id.pen_color_button_preto:
                drawingView.setPenColor(Color.BLACK);
                break;
            case R.id.pen_color_button_vermelho:
                drawingView.setPenColor(Color.RED);
                break;
            default:
                break;
        }
    }

    @Override public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        int seekBarId = seekBar.getId();
        if (seekBarId == R.id.pen_size_seekbar) {
            drawingView.setPenSize(i);
        } else if (seekBarId == R.id.eraser_size_seekbar) {
            drawingView.setEraserSize(i);
        }
    }

    @Override public void onStartTrackingTouch(SeekBar seekBar) {
        //Intentionally Empty
    }

    @Override public void onStopTrackingTouch(SeekBar seekBar) {
        //Intentionally Empty
    }
}