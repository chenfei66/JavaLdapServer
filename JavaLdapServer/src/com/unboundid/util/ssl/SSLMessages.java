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
package com.unboundid.util.ssl;



import java.text.MessageFormat;
import java.util.ResourceBundle;
import java.util.concurrent.ConcurrentHashMap;



/**
 * This enum defines a set of message keys for messages in the
 * com.unboundid.util.ssl package, which correspond to messages in the
 * unboundid-ldapsdk-ssl.properties properties file.
 * <BR><BR>
 * This source file was generated from the properties file.
 * Do not edit it directly.
 */
enum SSLMessages
{
  /**
   * The certificate cannot be trusted because the end of the standard input stream was reached without finding information about whether to trust the presented certificate.
   */
  ERR_CERTIFICATE_REJECTED_BY_END_OF_STREAM("The certificate cannot be trusted because the end of the standard input stream was reached without finding information about whether to trust the presented certificate."),



  /**
   * The user rejected the provided certificate.
   */
  ERR_CERTIFICATE_REJECTED_BY_USER("The user rejected the provided certificate."),



  /**
   * The presented certificate ''{0}'' did not contain any of the acceptable addresses in the CN subject attribute or in a subjectAltName extension.
   */
  ERR_HOSTNAME_NOT_FOUND("The presented certificate ''{0}'' did not contain any of the acceptable addresses in the CN subject attribute or in a subjectAltName extension."),



  /**
   * Unable to verify an attempt to to establish a secure connection to ''{0}:{1,number,0}'' because an unexpected error was encountered during validation processing:  {2}
   */
  ERR_HOST_NAME_SSL_SOCKET_VERIFIER_EXCEPTION("Unable to verify an attempt to to establish a secure connection to ''{0}:{1,number,0}'' because an unexpected error was encountered during validation processing:  {2}"),



  /**
   * Hostname verification failed because the expected hostname ''{0}'' was not found in peer certificate ''{1}''.
   */
  ERR_HOST_NAME_SSL_SOCKET_VERIFIER_HOSTNAME_NOT_FOUND("Hostname verification failed because the expected hostname ''{0}'' was not found in peer certificate ''{1}''."),



  /**
   * Unable to verify an attempt to establish a secure connection to ''{0}:{1,number,0}'' because no peer certificates are available.
   */
  ERR_HOST_NAME_SSL_SOCKET_VERIFIER_NO_PEER_CERTS("Unable to verify an attempt to establish a secure connection to ''{0}:{1,number,0}'' because no peer certificates are available."),



  /**
   * Unable to verify an attempt to establish a secure connection to ''{0}:{1,number,0}'' because no session information is available for the connection.
   */
  ERR_HOST_NAME_SSL_SOCKET_VERIFIER_NO_SESSION("Unable to verify an attempt to establish a secure connection to ''{0}:{1,number,0}'' because no session information is available for the connection."),



  /**
   * Unable to verify an attempt to establish a secure connection to ''{0}:{1,number,0}'' because the peer certificate was not an X.509 certificate.  The reported certificate type is ''{2}''.
   */
  ERR_HOST_NAME_SSL_SOCKET_VERIFIER_PEER_NOT_X509("Unable to verify an attempt to establish a secure connection to ''{0}:{1,number,0}'' because the peer certificate was not an X.509 certificate.  The reported certificate type is ''{2}''."),



  /**
   * Unable to obtain key managers for key store file ''{0}'' using format ''{1}'':  {2}
   */
  ERR_KEYSTORE_CANNOT_GET_KEY_MANAGERS("Unable to obtain key managers for key store file ''{0}'' using format ''{1}'':  {2}"),



  /**
   * Unable to load key store ''{0}'' of type ''{1}'':  {2}
   */
  ERR_KEYSTORE_CANNOT_LOAD("Unable to load key store ''{0}'' of type ''{1}'':  {2}"),



  /**
   * Key store file ''{0}'' does not exist.
   */
  ERR_KEYSTORE_NO_SUCH_FILE("Key store file ''{0}'' does not exist."),



  /**
   * None of the configured set of enabled SSL protocols could be configured for use with the SSL socket.  The currently-enabled protocols are:  {0}.  The SSL socket indicated its supported protocols are:  {1}.  You may explicitly configure the enabled protocols using the {2} system property or by calling the {3} method.
   */
  ERR_NO_ENABLED_SSL_PROTOCOLS_AVAILABLE_FOR_SOCKET("None of the configured set of enabled SSL protocols could be configured for use with the SSL socket.  The currently-enabled protocols are:  {0}.  The SSL socket indicated its supported protocols are:  {1}.  You may explicitly configure the enabled protocols using the {2} system property or by calling the {3} method."),



  /**
   * Unable to access the PKCS#11 key store:  {0}
   */
  ERR_PKCS11_CANNOT_ACCESS("Unable to access the PKCS#11 key store:  {0}"),



  /**
   * Unable to obtain key managers for the PKCS#11 key store:  {0}
   */
  ERR_PKCS11_CANNOT_GET_KEY_MANAGERS("Unable to obtain key managers for the PKCS#11 key store:  {0}"),



  /**
   * Unable to obtain trust managers for trust store file ''{0}'' using format ''{1}'':  {2}
   */
  ERR_TRUSTSTORE_CANNOT_GET_TRUST_MANAGERS("Unable to obtain trust managers for trust store file ''{0}'' using format ''{1}'':  {2}"),



  /**
   * Unable to load trust store ''{0}'' of type ''{1}'':  {2}
   */
  ERR_TRUSTSTORE_CANNOT_LOAD("Unable to load trust store ''{0}'' of type ''{1}'':  {2}"),



  /**
   * Trust store file ''{0}'' does not exist.
   */
  ERR_TRUSTSTORE_NO_SUCH_FILE("Trust store file ''{0}'' does not exist."),



  /**
   * Unsupported trust store format ''{0}''.
   */
  ERR_TRUSTSTORE_UNSUPPORTED_FORMAT("Unsupported trust store format ''{0}''."),



  /**
   * The presented certificate ''{0}'' will not be valid until {1}.
   */
  ERR_VALIDITY_TOO_EARLY("The presented certificate ''{0}'' will not be valid until {1}."),



  /**
   * The presented certificate ''{0}'' expired on {1}.
   */
  ERR_VALIDITY_TOO_LATE("The presented certificate ''{0}'' expired on {1}."),



  /**
   * The client presented the following certificate:
   */
  INFO_PROMPT_CLIENT_HEADING("The client presented the following certificate:"),



  /**
   * Issuer[{0,number,0}] Subject:  {1}
   */
  INFO_PROMPT_ISSUER_SUBJECT("Issuer[{0,number,0}] Subject:  {1}"),



  /**
   * MD5 Fingerprint:  {0}
   */
  INFO_PROMPT_MD5_FINGERPRINT("MD5 Fingerprint:  {0}"),



  /**
   * Do you wish to trust this certificate?  Enter 'y' or 'n': 
   */
  INFO_PROMPT_MESSAGE("Do you wish to trust this certificate?  Enter 'y' or 'n': "),



  /**
   * The server presented the following certificate:
   */
  INFO_PROMPT_SERVER_HEADING("The server presented the following certificate:"),



  /**
   * SHA-1 Fingerprint:  {0}
   */
  INFO_PROMPT_SHA1_FINGERPRINT("SHA-1 Fingerprint:  {0}"),



  /**
   * Subject:  {0}
   */
  INFO_PROMPT_SUBJECT("Subject:  {0}"),



  /**
   * The certificate is valid from {0} to {1}.
   */
  INFO_PROMPT_VALIDITY("The certificate is valid from {0} to {1}."),



  /**
   * WARNING:  This certificate is expired.
   */
  WARN_PROMPT_EXPIRED("WARNING:  This certificate is expired."),



  /**
   * WARNING:  The current time is before the certificate validity start date.
   */
  WARN_PROMPT_NOT_YET_VALID("WARNING:  The current time is before the certificate validity start date."),



  /**
   * WARNING:  The certificate is self-signed.
   */
  WARN_PROMPT_SELF_SIGNED("WARNING:  The certificate is self-signed.");



  /**
   * The resource bundle that will be used to load the properties file.
   */
  private static final ResourceBundle RESOURCE_BUNDLE;
  static
  {
    ResourceBundle rb = null;
    try
    {
      rb = ResourceBundle.getBundle("unboundid-ldapsdk-ssl");
    } catch (Exception e) {}
    RESOURCE_BUNDLE = rb;
  }



  /**
   * The map that will be used to hold the unformatted message strings, indexed by property name.
   */
  private static final ConcurrentHashMap<SSLMessages,String> MESSAGE_STRINGS = new ConcurrentHashMap<SSLMessages,String>();



  /**
   * The map that will be used to hold the message format objects, indexed by property name.
   */
  private static final ConcurrentHashMap<SSLMessages,MessageFormat> MESSAGES = new ConcurrentHashMap<SSLMessages,MessageFormat>();



  // The default text for this message
  private final String defaultText;



  /**
   * Creates a new message key.
   */
  private SSLMessages(final String defaultText)
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

