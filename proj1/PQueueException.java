/**
 * Reports priority queue exception
 * @author Duncan <br>
 * <pre>
 * File: PQueueException.java<br>
 * Course: csc 3102.001
 * Project: # 1
 * Instructor: Dr. Duncan
 *
 * DO NOT REMOVE THIS NOTICE (GNU GPL V2):
 * Contact Information: duncanw@lsu.edu
 * Copyright (c) 2026 William E. Duncan
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>
 * </pre>
 */


/**
 * This class reports PQueue exceptions.
 */
class PQueueException extends Exception 
{
    /**
     * Creates a new instance of <code>PQueueException</code> without detail
     * message.
     */
    public PQueueException() { }

    /**
     * Constructs an instance of <code>PQueueException</code> with the specified
     * detail message.
     * @param msg the detail message.
     */
    public PQueueException(String msg) 
    {
        super(msg);
    }
}