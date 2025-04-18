/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.spark.util

import org.apache.spark.annotation.DeveloperApi

/**
 * :: : DeveloperApi ::
 * Utils for querying Spark logs with Spark SQL.
 *
 * @since 4.0.0
 */
@DeveloperApi
object LogUtils {
  /**
   * Schema for structured Spark logs.
   * Example usage:
   *   val logDf = spark.read.schema(SPARK_LOG_SCHEMA).json("path/to/logs")
   */
  val SPARK_LOG_SCHEMA: String = """
    |ts TIMESTAMP,
    |level STRING,
    |msg STRING,
    |context map<STRING, STRING>,
    |exception STRUCT<
    |  class STRING,
    |  msg STRING,
    |  stacktrace ARRAY<STRUCT<
    |    class STRING,
    |    method STRING,
    |    file STRING,
    |    line STRING
    |  >>
    |>,
    |logger STRING""".stripMargin
}
