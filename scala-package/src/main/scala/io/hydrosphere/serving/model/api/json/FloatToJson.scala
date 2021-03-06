package io.hydrosphere.serving.model.api.json

import io.hydrosphere.serving.tensorflow.tensor.FloatTensor
import spray.json.JsNumber

object FloatToJson extends TensorJsonLens[FloatTensor] {
  override def convert = JsNumber.apply(_)
}
