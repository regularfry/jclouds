/**
 *
 * Copyright (C) 2009 Cloud Conscious, LLC. <info@cloudconscious.com>
 *
 * ====================================================================
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 * ====================================================================
 */
package org.jclouds.aws.ec2.options;

import java.util.Set;

import org.jclouds.aws.ec2.domain.Region;
import org.jclouds.aws.ec2.options.internal.BaseEC2RequestOptions;

/**
 * Contains options supported in the Form API for the DescribeRegions operation. <h2>
 * Usage</h2> The recommended way to instantiate a DescribeRegionsOptions object is to statically
 * import DescribeRegionsOptions.Builder.* and invoke a static creation method followed by an
 * instance mutator (if needed):
 * <p/>
 * <code>
 * import static org.jclouds.aws.ec2.options.DescribeRegionsOptions.Builder.*
 * <p/>
 * EC2Client connection = // get connection
 * Future<SortedSet<ImageMetadata>> images = connection.getRegionsAndRegionsServices().describeRegions(regions("us-east-1a", "us-east-1b"));
 * <code>
 * 
 * @author Adrian Cole
 * @see <a
 *      href="http://docs.amazonwebservices.com/AWSEC2/latest/APIReference/index.html?ApiReference-form-DescribeRegions.html"
 *      />
 */
public class DescribeRegionsOptions extends BaseEC2RequestOptions {

   /**
    * Name of a Region.
    */
   public DescribeRegionsOptions regions(Region... regions) {
      String[] regionStrings = new String[regions.length];
      for (int i = 0; i < regionStrings.length; i++)
         regionStrings[i] = regions[i].value();
      indexFormValuesWithPrefix("RegionName", regionStrings);
      return this;
   }

   public Set<String> getZones() {
      return getFormValuesWithKeysPrefixedBy("RegionName.");
   }

   public static class Builder {

      /**
       * @see DescribeRegionsOptions#regions(Region[] )
       */
      public static DescribeRegionsOptions regions(Region... regions) {
         DescribeRegionsOptions options = new DescribeRegionsOptions();
         return options.regions(regions);
      }

   }
}