/*
 * Copyright 2008-2014 UnboundID Corp.
 * All Rights Reserved.
 */
/*
 * Copyright (C) 2008-2014 UnboundID Corp.
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
package com.unboundid.util.args;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import com.unboundid.util.Mutable;
import com.unboundid.util.ThreadSafety;
import com.unboundid.util.ThreadSafetyLevel;

import static com.unboundid.util.args.ArgsMessages.*;



/**
 * This class defines an argument that is intended to hold one or more integer
 * values.  Integer arguments must take values.  By default, any value will be
 * allowed, but it is possible to restrict the set of values to a given range
 * using upper and lower bounds.
 */
@Mutable()
@ThreadSafety(level=ThreadSafetyLevel.NOT_THREADSAFE)
public final class IntegerArgument
       extends Argument
{
  /**
   * The serial version UID for this serializable class.
   */
  private static final long serialVersionUID = 3364985217337213643L;



  // The set of values assigned to this argument.
  private final ArrayList<Integer> values;

  // The lower bound for this argument.
  private final int lowerBound;

  // The upper bound for this argument.
  private final int upperBound;

  // The list of default values that will be used if no values were provided.
  private final List<Integer> defaultValues;



  /**
   * Creates a new integer argument with the provided information.  There will
   * not be any default values, nor will there be any restriction on values that
   * may be assigned to this argument.
   *
   * @param  shortIdentifier   The short identifier for this argument.  It may
   *                           not be {@code null} if the long identifier is
   *                           {@code null}.
   * @param  longIdentifier    The long identifier for this argument.  It may
   *                           not be {@code null} if the short identifier is
   *                           {@code null}.
   * @param  isRequired        Indicates whether this argument is required to
   *                           be provided.
   * @param  maxOccurrences    The maximum number of times this argument may be
   *                           provided on the command line.  A value less than
   *                           or equal to zero indicates that it may be present
   *                           any number of times.
   * @param  valuePlaceholder  A placeholder to display in usage information to
   *                           indicate that a value must be provided.  It must
   *                           not be {@code null}.
   * @param  description       A human-readable description for this argument.
   *                           It must not be {@code null}.
   *
   * @throws  ArgumentException  If there is a problem with the definition of
   *                             this argument.
   */
  public IntegerArgument(final Character shortIdentifier,
                         final String longIdentifier, final boolean isRequired,
                         final int maxOccurrences,
                         final String valuePlaceholder,
                         final String description)
         throws ArgumentException
  {
    this(shortIdentifier, longIdentifier, isRequired,  maxOccurrences,
         valuePlaceholder, description, Integer.MIN_VALUE, Integer.MAX_VALUE,
         (List<Integer>) null);
  }



  /**
   * Creates a new integer argument with the provided information.  There will
   * not be any default values, but the range of values that will be allowed may
   * be restricted.
   *
   * @param  shortIdentifier   The short identifier for this argument.  It may
   *                           not be {@code null} if the long identifier is
   *                           {@code null}.
   * @param  longIdentifier    The long identifier for this argument.  It may
   *                           not be {@code null} if the short identifier is
   *                           {@code null}.
   * @param  isRequired        Indicates whether this argument is required to
   *                           be provided.
   * @param  maxOccurrences    The maximum number of times this argument may be
   *                           provided on the command line.  A value less than
   *                           or equal to zero indicates that it may be present
   *                           any number of times.
   * @param  valuePlaceholder  A placeholder to display in usage information to
   *                           indicate that a value must be provided.  It must
   *                           not be {@code null}.
   * @param  description       A human-readable description for this argument.
   *                           It must not be {@code null}.
   * @param  lowerBound        The smallest value that this argument is allowed
   *                           to have.  It should be {@code Integer.MIN_VALUE}
   *                           if there should be no lower bound.
   * @param  upperBound        The largest value that this argument is allowed
   *                           to have.  It should be {@code Integer.MAX_VALUE}
   *                           if there should be no upper bound.
   *
   * @throws  ArgumentException  If there is a problem with the definition of
   *                             this argument.
   */
  public IntegerArgument(final Character shortIdentifier,
                         final String longIdentifier, final boolean isRequired,
                         final int maxOccurrences,
                         final String valuePlaceholder,
                         final String description,
                         final int lowerBound, final int upperBound)
         throws ArgumentException
  {
    this(shortIdentifier, longIdentifier, isRequired,  maxOccurrences,
         valuePlaceholder, description, lowerBound, upperBound,
         (List<Integer>) null);
  }



  /**
   * Creates a new integer argument with the provided information.  There will
   * not be any restriction on values that may be assigned to this argument.
   *
   * @param  shortIdentifier   The short identifier for this argument.  It may
   *                           not be {@code null} if the long identifier is
   *                           {@code null}.
   * @param  longIdentifier    The long identifier for this argument.  It may
   *                           not be {@code null} if the short identifier is
   *                           {@code null}.
   * @param  isRequired        Indicates whether this argument is required to
   *                           be provided.
   * @param  maxOccurrences    The maximum number of times this argument may be
   *                           provided on the command line.  A value less than
   *                           or equal to zero indicates that it may be present
   *                           any number of times.
   * @param  valuePlaceholder  A placeholder to display in usage information to
   *                           indicate that a value must be provided.  It must
   *                           not be {@code null}.
   * @param  description       A human-readable description for this argument.
   *                           It must not be {@code null}.
   * @param  defaultValue      The default value that will be used for this
   *                           argument if no values are provided.  It may be
   *                           {@code null} if there should not be a default
   *                           value.
   *
   * @throws  ArgumentException  If there is a problem with the definition of
   *                             this argument.
   */
  public IntegerArgument(final Character shortIdentifier,
                         final String longIdentifier, final boolean isRequired,
                         final int maxOccurrences,
                         final String valuePlaceholder,
                         final String description,
                         final Integer defaultValue)
         throws ArgumentException
  {
    this(shortIdentifier, longIdentifier, isRequired,  maxOccurrences,
         valuePlaceholder, description, Integer.MIN_VALUE, Integer.MAX_VALUE,
         ((defaultValue == null) ? null : Arrays.asList(defaultValue)));
  }



  /**
   * Creates a new integer argument with the provided information.  There will
   * not be any restriction on values that may be assigned to this argument.
   *
   * @param  shortIdentifier   The short identifier for this argument.  It may
   *                           not be {@code null} if the long identifier is
   *                           {@code null}.
   * @param  longIdentifier    The long identifier for this argument.  It may
   *                           not be {@code null} if the short identifier is
   *                           {@code null}.
   * @param  isRequired        Indicates whether this argument is required to
   *                           be provided.
   * @param  maxOccurrences    The maximum number of times this argument may be
   *                           provided on the command line.  A value less than
   *                           or equal to zero indicates that it may be present
   *                           any number of times.
   * @param  valuePlaceholder  A placeholder to display in usage information to
   *                           indicate that a value must be provided.  It must
   *                           not be {@code null}.
   * @param  description       A human-readable description for this argument.
   *                           It must not be {@code null}.
   * @param  defaultValues     The set of default values that will be used for
   *                           this argument if no values are provided.
   *
   * @throws  ArgumentException  If there is a problem with the definition of
   *                             this argument.
   */
  public IntegerArgument(final Character shortIdentifier,
                         final String longIdentifier, final boolean isRequired,
                         final int maxOccurrences,
                         final String valuePlaceholder,
                         final String description,
                         final List<Integer> defaultValues)
         throws ArgumentException
  {
    this(shortIdentifier, longIdentifier, isRequired,  maxOccurrences,
         valuePlaceholder, description, Integer.MIN_VALUE, Integer.MAX_VALUE,
         defaultValues);
  }



  /**
   * Creates a new integer argument with the provided information.
   *
   * @param  shortIdentifier   The short identifier for this argument.  It may
   *                           not be {@code null} if the long identifier is
   *                           {@code null}.
   * @param  longIdentifier    The long identifier for this argument.  It may
   *                           not be {@code null} if the short identifier is
   *                           {@code null}.
   * @param  isRequired        Indicates whether this argument is required to
   *                           be provided.
   * @param  maxOccurrences    The maximum number of times this argument may be
   *                           provided on the command line.  A value less than
   *                           or equal to zero indicates that it may be present
   *                           any number of times.
   * @param  valuePlaceholder  A placeholder to display in usage information to
   *                           indicate that a value must be provided.  It must
   *                           not be {@code null}.
   * @param  description       A human-readable description for this argument.
   *                           It must not be {@code null}.
   * @param  lowerBound        The smallest value that this argument is allowed
   *                           to have.  It should be {@code Integer.MIN_VALUE}
   *                           if there should be no lower bound.
   * @param  upperBound        The largest value that this argument is allowed
   *                           to have.  It should be {@code Integer.MAX_VALUE}
   *                           if there should be no upper bound.
   * @param  defaultValue      The default value that will be used for this
   *                           argument if no values are provided.  It may be
   *                           {@code null} if there should not be a default
   *                           value.
   *
   * @throws  ArgumentException  If there is a problem with the definition of
   *                             this argument.
   */
  public IntegerArgument(final Character shortIdentifier,
                         final String longIdentifier, final boolean isRequired,
                         final int maxOccurrences,
                         final String valuePlaceholder,
                         final String description, final int lowerBound,
                         final int upperBound,
                         final Integer defaultValue)
         throws ArgumentException
  {
    this(shortIdentifier, longIdentifier, isRequired,  maxOccurrences,
         valuePlaceholder, description, lowerBound, upperBound,
         ((defaultValue == null) ? null : Arrays.asList(defaultValue)));
  }



  /**
   * Creates a new integer argument with the provided information.
   *
   * @param  shortIdentifier   The short identifier for this argument.  It may
   *                           not be {@code null} if the long identifier is
   *                           {@code null}.
   * @param  longIdentifier    The long identifier for this argument.  It may
   *                           not be {@code null} if the short identifier is
   *                           {@code null}.
   * @param  isRequired        Indicates whether this argument is required to
   *                           be provided.
   * @param  maxOccurrences    The maximum number of times this argument may be
   *                           provided on the command line.  A value less than
   *                           or equal to zero indicates that it may be present
   *                           any number of times.
   * @param  valuePlaceholder  A placeholder to display in usage information to
   *                           indicate that a value must be provided.  It must
   *                           not be {@code null}.
   * @param  description       A human-readable description for this argument.
   *                           It must not be {@code null}.
   * @param  lowerBound        The smallest value that this argument is allowed
   *                           to have.  It should be {@code Integer.MIN_VALUE}
   *                           if there should be no lower bound.
   * @param  upperBound        The largest value that this argument is allowed
   *                           to have.  It should be {@code Integer.MAX_VALUE}
   *                           if there should be no upper bound.
   * @param  defaultValues     The set of default values that will be used for
   *                           this argument if no values are provided.
   *
   * @throws  ArgumentException  If there is a problem with the definition of
   *                             this argument.
   */
  public IntegerArgument(final Character shortIdentifier,
                         final String longIdentifier, final boolean isRequired,
                         final int maxOccurrences,
                         final String valuePlaceholder,
                         final String description, final int lowerBound,
                         final int upperBound,
                         final List<Integer> defaultValues)
         throws ArgumentException
  {
    super(shortIdentifier, longIdentifier, isRequired,  maxOccurrences,
          valuePlaceholder, description);

    if (valuePlaceholder == null)
    {
      throw new ArgumentException(ERR_ARG_MUST_TAKE_VALUE.get(
                                       getIdentifierString()));
    }

    this.lowerBound = lowerBound;
    this.upperBound = upperBound;

    if ((defaultValues == null) || defaultValues.isEmpty())
    {
      this.defaultValues = null;
    }
    else
    {
      this.defaultValues = Collections.unmodifiableList(defaultValues);
    }

    values = new ArrayList<Integer>();
  }



  /**
   * Creates a new integer argument that is a "clean" copy of the provided
   * source argument.
   *
   * @param  source  The source argument to use for this argument.
   */
  private IntegerArgument(final IntegerArgument source)
  {
    super(source);

    lowerBound    = source.lowerBound;
    upperBound    = source.upperBound;
    defaultValues = source.defaultValues;
    values        = new ArrayList<Integer>();
  }



  /**
   * Retrieves the smallest value that this argument will be allowed to have.
   *
   * @return  The smallest value that this argument will be allowed to have.
   */
  public int getLowerBound()
  {
    return lowerBound;
  }



  /**
   * Retrieves the largest value that this argument will be allowed to have.
   *
   * @return  The largest value that this argument will be allowed to have.
   */
  public int getUpperBound()
  {
    return upperBound;
  }



  /**
   * Retrieves the list of default values for this argument, which will be used
   * if no values were provided.
   *
   * @return   The list of default values for this argument, or {@code null} if
   *           there are no default values.
   */
  public List<Integer> getDefaultValues()
  {
    return defaultValues;
  }



  /**
   * {@inheritDoc}
   */
  @Override()
  protected void addValue(final String valueString)
            throws ArgumentException
  {
    final int intValue;
    try
    {
      intValue = Integer.parseInt(valueString);
    }
    catch (Exception e)
    {
      throw new ArgumentException(ERR_INTEGER_VALUE_NOT_INT.get(valueString,
                                       getIdentifierString()), e);
    }

    if (intValue < lowerBound)
    {
      throw new ArgumentException(ERR_INTEGER_VALUE_BELOW_LOWER_BOUND.get(
                                       intValue, getIdentifierString(),
                                       lowerBound));
    }

    if (intValue > upperBound)
    {
      throw new ArgumentException(ERR_INTEGER_VALUE_ABOVE_UPPER_BOUND.get(
                                       intValue, getIdentifierString(),
                                       upperBound));
    }

    if (values.size() >= getMaxOccurrences())
    {
      throw new ArgumentException(ERR_ARG_MAX_OCCURRENCES_EXCEEDED.get(
                                       getIdentifierString()));
    }

    values.add(intValue);
  }



  /**
   * Retrieves the value for this argument, or the default value if none was
   * provided.  If this argument has multiple values, then the first will be
   * returned.
   *
   * @return  The value for this argument, or the default value if none was
   *          provided, or {@code null} if it does not have any values or
   *          default values.
   */
  public Integer getValue()
  {
    if (values.isEmpty())
    {
      if ((defaultValues == null) || defaultValues.isEmpty())
      {
        return null;
      }
      else
      {
        return defaultValues.get(0);
      }
    }

    return values.get(0);
  }



  /**
   * Retrieves the set of values for this argument, or the default values if
   * none were provided.
   *
   * @return  The set of values for this argument, or the default values if none
   *          were provided.
   */
  public List<Integer> getValues()
  {
    if (values.isEmpty() && (defaultValues != null))
    {
      return defaultValues;
    }

    return Collections.unmodifiableList(values);
  }



  /**
   * {@inheritDoc}
   */
  @Override()
  protected boolean hasDefaultValue()
  {
    return ((defaultValues != null) && (! defaultValues.isEmpty()));
  }



  /**
   * {@inheritDoc}
   */
  @Override()
  public String getDataTypeName()
  {
    return INFO_INTEGER_TYPE_NAME.get();
  }



  /**
   * {@inheritDoc}
   */
  @Override()
  public String getValueConstraints()
  {
    return INFO_INTEGER_CONSTRAINTS_LOWER_AND_UPPER_BOUND.get(lowerBound,
         upperBound);
  }



  /**
   * {@inheritDoc}
   */
  @Override()
  public IntegerArgument getCleanCopy()
  {
    return new IntegerArgument(this);
  }



  /**
   * {@inheritDoc}
   */
  @Override()
  public void toString(final StringBuilder buffer)
  {
    buffer.append("IntegerArgument(");
    appendBasicToStringInfo(buffer);

    buffer.append(", lowerBound=");
    buffer.append(lowerBound);
    buffer.append(", upperBound=");
    buffer.append(upperBound);

    if ((defaultValues != null) && (! defaultValues.isEmpty()))
    {
      if (defaultValues.size() == 1)
      {
        buffer.append(", defaultValue='");
        buffer.append(defaultValues.get(0).toString());
      }
      else
      {
        buffer.append(", defaultValues={");

        final Iterator<Integer> iterator = defaultValues.iterator();
        while (iterator.hasNext())
        {
          buffer.append('\'');
          buffer.append(iterator.next().toString());
          buffer.append('\'');

          if (iterator.hasNext())
          {
            buffer.append(", ");
          }
        }

        buffer.append('}');
      }
    }

    buffer.append(')');
  }
}
