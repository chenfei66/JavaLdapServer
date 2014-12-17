/*
 * Copyright 2014 UnboundID Corp.
 * All Rights Reserved.
 */
/*
 * Copyright (C) 2014 UnboundID Corp.
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License (GPLv2 only)
 * or the terms of the GNU Lesser General Public License (LGPLv2.1 only)
 * as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, see <http://www.gnu.org/licenses>.
 */
package com.unboundid.ldap.listener.interceptor;



import java.text.MessageFormat;
import java.util.ResourceBundle;
import java.util.concurrent.ConcurrentHashMap;



/**
 * This enum defines a set of message keys for messages in the
 * com.unboundid.ldap.listener.interceptor package, which correspond to messages in the
 * unboundid-ldapsdk-interceptor.properties properties file.
 * <BR><BR>
 * This source file was generated from the properties file.
 * Do not edit it directly.
 */
enum InterceptorMessages
{
  /**
   * An unexpected error was encountered during request processing for operation {0} in an in-memory operation interceptor of type {1}:  {2}
   */
  ERR_DS_INTERCEPTOR_REQUEST_ERROR("An unexpected error was encountered during request processing for operation {0} in an in-memory operation interceptor of type {1}:  {2}"),



  /**
   * An unexpected error was encountered during result processing for operation {0} in an in-memory operation interceptor of type {1}:  {2}
   */
  ERR_DS_INTERCEPTOR_RESULT_ERROR("An unexpected error was encountered during result processing for operation {0} in an in-memory operation interceptor of type {1}:  {2}");



  /**
   * The resource bundle that will be used to load the properties file.
   */
  private static final ResourceBundle RESOURCE_BUNDLE;
  static
  {
    ResourceBundle rb = null;
    try
    {
      rb = ResourceBundle.getBundle("unboundid-ldapsdk-interceptor");
    } catch (Exception e) {}
    RESOURCE_BUNDLE = rb;
  }



  /**
   * The map that will be used to hold the unformatted message strings, indexed by property name.
   */
  private static final ConcurrentHashMap<InterceptorMessages,String> MESSAGE_STRINGS = new ConcurrentHashMap<InterceptorMessages,String>();



  /**
   * The map that will be used to hold the message format objects, indexed by property name.
   */
  private static final ConcurrentHashMap<InterceptorMessages,MessageFormat> MESSAGES = new ConcurrentHashMap<InterceptorMessages,MessageFormat>();



  // The default text for this message
  private final String defaultText;



  /**
   * Creates a new message key.
   */
  private InterceptorMessages(final String defaultText)
  {
    this.defaultText = defaultText;
  }



  /**
   * Retrieves a localized version of the message.
   * This method should only be used for messages which do not take any arguments.
   *
   * @return  A localized version of the message.
   */
  public String get()
  {
    String s = MESSAGE_STRINGS.get(this);
    if (s == null)
    {
      if (RESOURCE_BUNDLE == null)
      {
        return defaultText;
      }
      else
      {
        try
        {
          s = RESOURCE_BUNDLE.getString(name());
        }
        catch (final Exception e)
        {
          s = defaultText;
        }
        MESSAGE_STRINGS.putIfAbsent(this, s);
      }
    }
    return s;
  }



  /**
   * Retrieves a localized version of the message.
   *
   * @param  args  The arguments to use to format the message.
   *
   * @return  A localized version of the message.
   */
  public String get(final Object... args)
  {
    MessageFormat f = MESSAGES.get(this);
    if (f == null)
    {
      if (RESOURCE_BUNDLE == null)
      {
        f = new MessageFormat(defaultText);
      }
      else
      {
        try
        {
          f = new MessageFormat(RESOURCE_BUNDLE.getString(name()));
        }
        catch (final Exception e)
        {
          f = new MessageFormat(defaultText);
        }
      }
      MESSAGES.putIfAbsent(this, f);
    }
    synchronized (f)
    {
      return f.format(args);
    }
  }



  /**
   * Retrieves a string representation of this message key.
   *
   * @return  A string representation of this message key.
   */
  @Override()
  public String toString()
  {
    return get();
  }
}

