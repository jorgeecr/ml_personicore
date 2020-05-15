/*
 * Copyright 2019 The TensorFlow Authors. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Typeface;
import android.media.ImageReader.OnImageAvailableListener;
import android.os.SystemClock;
import android.util.Size;
import android.util.TypedValue;
import android.widget.Toast;
import java.io.IOException;
import java.util.List;

import Classifier;
import Classifier.Device;
import Classifier.Model;
import TextExtractor;

public class ClassifierActivity extends CameraActivity implements OnImageAvailableListener {
  private Bitmap rgbFrameBitmap = null;
  private long lastProcessingTimeMs;
  private Classifier classifier;
  private static final String TAG = "ClassifierActivity";
  /** Input image size of the model along x axis. */
  private int imageSizeX;
  /** Input image size of the model along y axis. */
  private int imageSizeY;


  @Override
  protected void processImage() {
    rgbFrameBitmap.setPixels(getRgbBytes(), 0, previewWidth, 0, 0, previewWidth, previewHeight);

    runInBackground(
        new Runnable() {
          @Override
          public void run() {
            if (classifier != null) {
              final long startTime = SystemClock.uptimeMillis();
              final int isGrid = classifier.recognizeImage(rgbFrameBitmap);
              // si es grid, extraer el texto
              if (isGrid == 1) {   
                Log.v(TAG, "si")
                // crop grid y extraer
              }
              lastProcessingTimeMs = SystemClock.uptimeMillis() - startTime;
              Log.v(TAG, "Grid detection result: %s", isGrid);
            }
            readyForNextImage();
          }
        });
  }

    // Updates the input image size.
    imageSizeX = classifier.getImageSizeX();
    imageSizeY = classifier.getImageSizeY();
  
}