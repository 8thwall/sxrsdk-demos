/* Copyright 2015 Samsung Electronics Co., LTD
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.samsungxr.simplesample;

import android.os.Bundle;

import com.samsungxr.SXRActivity;
import com.samsungxr.SXRAndroidResource;
import com.samsungxr.SXRCameraRig;
import com.samsungxr.SXRContext;
import com.samsungxr.SXRMain;
import com.samsungxr.SXRScene;
import com.samsungxr.SXRNode;
import com.samsungxr.SXRTexture;
import com.samsungxr.mixedreality.SXRAnchor;
import com.samsungxr.mixedreality.SXRHitResult;
import com.samsungxr.mixedreality.SXRMixedReality;
import com.samsungxr.mixedreality.SXRPlane;
import com.samsungxr.mixedreality.SXRTrackingState;
import com.samsungxr.mixedreality.IAnchorEvents;
import com.samsungxr.mixedreality.IMixedReality;
import com.samsungxr.mixedreality.IPlaneEvents;

public class SampleActivity extends SXRActivity {
    private static SXRMixedReality mixedReality;

    @Override
    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setMain(new SampleMain());
    }

    private static class SampleMain extends SXRMain {
        @Override
        public void onInit(SXRContext sxrContext) {
            SXRScene scene = sxrContext.getMainScene();
            scene.setBackgroundColor(1, 1, 1, 1);

            SXRTexture texture = sxrContext.getAssetLoader().loadTexture(new SXRAndroidResource(sxrContext, R.drawable.samsung_xr_512x512));

            // create a scene object (this constructor creates a rectangular scene
            // object that uses the standard texture shader
            SXRNode sceneObject = new SXRNode(sxrContext, 0.15f, 0.15f, texture);

            // set the scene object position
            sceneObject.getTransform().setPosition(0.0f, 0.0f, 00f);

            // add the scene object to the scene graph
            scene.addNode(sceneObject);

            mixedReality = new SXRMixedReality(scene);
            mixedReality.resume();

        }
    }
}
