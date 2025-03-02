package com.github.mikephil.charting.animation

import android.animation.TimeInterpolator
import androidx.annotation.RequiresApi

/**
 * Easing options.
 *
 * @author Daniel Cohen Gindi
 * @author Mick Ashton
 */
@RequiresApi(11)
object Easing {
    private const val DOUBLE_PI = 2f * Math.PI.toFloat()
    val Linear: EasingFunction = object : EasingFunction {
        override fun getInterpolation(input: Float): Float {
            return input
        }
    }
    val EaseInQuad: EasingFunction = object : EasingFunction {
        override fun getInterpolation(input: Float): Float {
            return input * input
        }
    }
    val EaseOutQuad: EasingFunction = object : EasingFunction {
        override fun getInterpolation(input: Float): Float {
            return -input * (input - 2f)
        }
    }
    val EaseInOutQuad: EasingFunction = object : EasingFunction {
        override fun getInterpolation(input: Float): Float {
            var input = input
            input *= 2f
            return if (input < 1f) {
                0.5f * input * input
            } else -0.5f * (--input * (input - 2f) - 1f)
        }
    }
    val EaseInCubic: EasingFunction = object : EasingFunction {
        override fun getInterpolation(input: Float): Float {
            return Math.pow(input.toDouble(), 3.0).toFloat()
        }
    }
    val EaseOutCubic: EasingFunction = object : EasingFunction {
        override fun getInterpolation(input: Float): Float {
            var input = input
            input--
            return Math.pow(input.toDouble(), 3.0).toFloat() + 1f
        }
    }
    val EaseInOutCubic: EasingFunction = object : EasingFunction {
        override fun getInterpolation(input: Float): Float {
            var input = input
            input *= 2f
            if (input < 1f) {
                return 0.5f * Math.pow(input.toDouble(), 3.0).toFloat()
            }
            input -= 2f
            return 0.5f * (Math.pow(input.toDouble(), 3.0).toFloat() + 2f)
        }
    }
    val EaseInQuart: EasingFunction = object : EasingFunction {
        override fun getInterpolation(input: Float): Float {
            return Math.pow(input.toDouble(), 4.0).toFloat()
        }
    }
    val EaseOutQuart: EasingFunction = object : EasingFunction {
        override fun getInterpolation(input: Float): Float {
            var input = input
            input--
            return -(Math.pow(input.toDouble(), 4.0).toFloat() - 1f)
        }
    }
    val EaseInOutQuart: EasingFunction = object : EasingFunction {
        override fun getInterpolation(input: Float): Float {
            var input = input
            input *= 2f
            if (input < 1f) {
                return 0.5f * Math.pow(input.toDouble(), 4.0).toFloat()
            }
            input -= 2f
            return -0.5f * (Math.pow(input.toDouble(), 4.0).toFloat() - 2f)
        }
    }
    val EaseInSine: EasingFunction = object : EasingFunction {
        override fun getInterpolation(input: Float): Float {
            return -Math.cos(input * (Math.PI / 2f)).toFloat() + 1f
        }
    }
    val EaseOutSine: EasingFunction = object : EasingFunction {
        override fun getInterpolation(input: Float): Float {
            return Math.sin(input * (Math.PI / 2f)).toFloat()
        }
    }
    val EaseInOutSine: EasingFunction = object : EasingFunction {
        override fun getInterpolation(input: Float): Float {
            return -0.5f * (Math.cos(Math.PI * input).toFloat() - 1f)
        }
    }
    val EaseInExpo: EasingFunction = object : EasingFunction {
        override fun getInterpolation(input: Float): Float {
            return if (input == 0f) 0f else Math.pow(2.0, (10f * (input - 1f)).toDouble()).toFloat()
        }
    }
    val EaseOutExpo: EasingFunction = object : EasingFunction {
        override fun getInterpolation(input: Float): Float {
            return if (input == 1f) 1f else -Math.pow(2.0, (-10f * (input + 1f)).toDouble())
                .toFloat()
        }
    }
    val EaseInOutExpo: EasingFunction = object : EasingFunction {
        override fun getInterpolation(input: Float): Float {
            var input = input
            if (input == 0f) {
                return 0f
            } else if (input == 1f) {
                return 1f
            }
            input *= 2f
            return if (input < 1f) {
                0.5f * Math.pow(2.0, (10f * (input - 1f)).toDouble()).toFloat()
            } else 0.5f * (-Math.pow(2.0, (-10f * --input).toDouble())
                .toFloat() + 2f)
        }
    }
    val EaseInCirc: EasingFunction = object : EasingFunction {
        override fun getInterpolation(input: Float): Float {
            return -(Math.sqrt((1f - input * input).toDouble()).toFloat() - 1f)
        }
    }
    val EaseOutCirc: EasingFunction = object : EasingFunction {
        override fun getInterpolation(input: Float): Float {
            var input = input
            input--
            return Math.sqrt((1f - input * input).toDouble()).toFloat()
        }
    }
    val EaseInOutCirc: EasingFunction = object : EasingFunction {
        override fun getInterpolation(input: Float): Float {
            var input = input
            input *= 2f
            return if (input < 1f) {
                -0.5f * (Math.sqrt((1f - input * input).toDouble()).toFloat() - 1f)
            } else 0.5f * (Math.sqrt((1f - 2f.let { input -= it; input } * input).toDouble())
                .toFloat() + 1f)
        }
    }
    val EaseInElastic: EasingFunction = object : EasingFunction {
        override fun getInterpolation(input: Float): Float {
            var input = input
            if (input == 0f) {
                return 0f
            } else if (input == 1f) {
                return 1f
            }
            val p = 0.3f
            val s = p / DOUBLE_PI * Math.asin(1.0).toFloat()
            return -(Math.pow(2.0, (10f * 1f.let { input -= it; input }).toDouble())
                .toFloat() * Math.sin(((input - s) * DOUBLE_PI / p).toDouble()).toFloat())
        }
    }
    val EaseOutElastic: EasingFunction = object : EasingFunction {
        override fun getInterpolation(input: Float): Float {
            if (input == 0f) {
                return 0f
            } else if (input == 1f) {
                return 1f
            }
            val p = 0.3f
            val s = p / DOUBLE_PI * Math.asin(1.0).toFloat()
            return (1f
                    + Math.pow(2.0, (-10f * input).toDouble())
                .toFloat() * Math.sin(((input - s) * DOUBLE_PI / p).toDouble()).toFloat())
        }
    }
    val EaseInOutElastic: EasingFunction = object : EasingFunction {
        override fun getInterpolation(input: Float): Float {
            var input = input
            if (input == 0f) {
                return 0f
            }
            input *= 2f
            if (input == 2f) {
                return 1f
            }
            val p = 1f / 0.45f
            val s = 0.45f / DOUBLE_PI * Math.asin(1.0).toFloat()
            return if (input < 1f) {
                (-0.5f
                        * (Math.pow(2.0, (10f * 1f.let { input -= it; input }).toDouble())
                    .toFloat() * Math.sin(((input * 1f - s) * DOUBLE_PI * p).toDouble())
                    .toFloat()))
            } else 1f + (0.5f
                    * Math.pow(2.0, (-10f * 1f.let { input -= it; input }).toDouble())
                .toFloat() * Math.sin(((input * 1f - s) * DOUBLE_PI * p).toDouble())
                .toFloat())
        }
    }
    val EaseInBack: EasingFunction = object : EasingFunction {
        override fun getInterpolation(input: Float): Float {
            val s = 1.70158f
            return input * input * ((s + 1f) * input - s)
        }
    }
    val EaseOutBack: EasingFunction = object : EasingFunction {
        override fun getInterpolation(input: Float): Float {
            var input = input
            val s = 1.70158f
            input--
            return input * input * ((s + 1f) * input + s) + 1f
        }
    }
    val EaseInOutBack: EasingFunction = object : EasingFunction {
        override fun getInterpolation(input: Float): Float {
            var input = input
            var s = 1.70158f
            input *= 2f
            return if (input < 1f) {
                0.5f * (input * input * ((1.525f.let { s *= it; s } + 1f) * input - s))
            } else 0.5f * (2f.let { input -= it; input } * input * ((1.525f.let { s *= it; s } + 1f) * input + s) + 2f)
        }
    }
    val EaseInBounce: EasingFunction = object : EasingFunction {
        override fun getInterpolation(input: Float): Float {
            return 1f - EaseOutBounce.getInterpolation(1f - input)
        }
    }
    val EaseOutBounce: EasingFunction = object : EasingFunction {
        override fun getInterpolation(input: Float): Float {
            var input = input
            val s = 7.5625f
            if (input < 1f / 2.75f) {
                return s * input * input
            } else if (input < 2f / 2.75f) {
                return s * (1.5f / 2.75f).let { input -= it; input } * input + 0.75f
            } else if (input < 2.5f / 2.75f) {
                return s * (2.25f / 2.75f).let { input -= it; input } * input + 0.9375f
            }
            return s * (2.625f / 2.75f).let { input -= it; input } * input + 0.984375f
        }
    }
    val EaseInOutBounce: EasingFunction = object : EasingFunction {
        override fun getInterpolation(input: Float): Float {
            return if (input < 0.5f) {
                EaseInBounce.getInterpolation(input * 2f) * 0.5f
            } else EaseOutBounce.getInterpolation(
                input * 2f - 1f
            ) * 0.5f + 0.5f
        }
    }

    interface EasingFunction : TimeInterpolator {
        override fun getInterpolation(input: Float): Float
    }
}