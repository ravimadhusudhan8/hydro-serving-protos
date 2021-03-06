package io.hydrosphere.serving.model.api

import io.hydrosphere.serving.contract.model_contract.ModelContract

case class ModelMetadata(
  modelName: String,
  modelType: ModelType,
  contract: ModelContract
)