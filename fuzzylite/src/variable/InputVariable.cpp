// #BEGIN_LICENSE
// fuzzylite: a fuzzy logic control library in C++
// Copyright (C) 2014  Juan Rada-Vilela
// 
// This file is part of fuzzylite.
//
// fuzzylite is free software: you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// fuzzylite is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.
//
// You should have received a copy of the GNU General Public License
// along with fuzzylite.  If not, see <http://www.gnu.org/licenses/>.
// #END_LICENSE

/*
 * InputVariable.cpp
 *
 *  Created on: 2/12/2012
 *      Author: jcrada
 */

#include "fl/variable/InputVariable.h"
#include "fl/imex/FllExporter.h"

#include <sstream>

namespace fl {

    InputVariable::InputVariable(const std::string& name, scalar minimum, scalar maximum)
    : Variable(name, minimum, maximum), _inputValue(fl::nan) {
    }

    InputVariable::~InputVariable() {
    }

    void InputVariable::setInputValue(scalar inputValue) {
        this->_inputValue = inputValue;
    }

    scalar InputVariable::getInputValue() const {
        return this->_inputValue;
    }

    std::string InputVariable::fuzzyInputValue() const {
        return fuzzify(_inputValue);
    }

    std::string InputVariable::toString() const {
        return FllExporter("", "; ").toString(this);
    }

    void InputVariable::clear() {
        Variable::clear();
        setInputValue(fl::nan);
    }


}
