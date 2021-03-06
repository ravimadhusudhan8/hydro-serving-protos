package io.hydrosphere.serving.model.api.description

import io.hydrosphere.serving.tensorflow.types.DataType

case class FieldDescription(
  fieldName: String,
  dataType: DataType,
  shape: Option[Seq[Long]]
)
