/**
 * Copyright (C) 2024 Document Node Pty Ltd
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.docstr.gwt;

import org.docstr.gwt.options.CompilerOptions;
import org.docstr.gwt.options.DevModeOptions;
import org.docstr.gwt.options.GwtTestOptions;
import org.docstr.gwt.options.SuperDevOptions;
import org.gradle.api.Action;
import org.gradle.api.provider.Property;
import org.gradle.api.tasks.Nested;

/**
 * GWT plugin extension
 */
public abstract class GwtPluginExtension extends AbstractBaseOptions {

  /**
   * The GWT version to use
   *
   * @return The GWT version
   */
  public abstract Property<String> getGwtVersion();

  /**
   * Nested extension for compiler options
   *
   * @return The compiler options
   */
  @Nested
  public abstract CompilerOptions getCompiler();

  /**
   * Nested extension for dev mode options
   *
   * @return The dev mode options
   */
  @Nested
  public abstract DevModeOptions getDevMode();

  /**
   * Nested extension for test options
   *
   * @return The test options
   */
  @Nested
  public abstract GwtTestOptions getGwtTest();

  /**
   * Nested extension for super dev options
   *
   * @return The super dev options
   */
  @Nested
  public abstract SuperDevOptions getSuperDev();

  /**
   * Configures the compiler options
   *
   * @param action The action to configure the compiler options
   */
  public void compiler(Action<? super CompilerOptions> action) {
    action.execute(getCompiler());
  }

  /**
   * Configures the dev mode options
   *
   * @param action The action to configure the dev mode options
   */
  public void devMode(Action<? super DevModeOptions> action) {
    action.execute(getDevMode());
  }

  /**
   * Configures the super dev options
   *
   * @param action The action to configure the super dev options
   */
  public void superDev(Action<? super SuperDevOptions> action) {
    action.execute(getSuperDev());
  }
}
