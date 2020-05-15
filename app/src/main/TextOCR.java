FirebaseVisionImage image = FirebaseVisionImage.fromBitmap(bitmap);

FirebaseVisionTextRecognizer detector = FirebaseVision.getInstance()
        .getOnDeviceTextRecognizer();

Task<FirebaseVisionText> result =
        detector.processImage(image)
                .addOnSuccessListener(new OnSuccessListener<FirebaseVisionText>() {
                    @Override
                    public void onSuccess(FirebaseVisionText firebaseVisionText) {
                        // Task completed successfully
                        // ...
                    }
                })
                .addOnFailureListener(
                        new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                // Task failed with an exception
                                // ...
                            }
                        });

