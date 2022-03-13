#version 330

layout (location =0) in vec3 position;
layout (location =1) in vec4 inColour;
layout (location =2) in vec2 texCoord;

out vec4 outColour;
out vec2 outTexCoord;

uniform mat4 worldMatrix;
uniform mat4 projectionMatrix;

void main()
{
    gl_Position = projectionMatrix * worldMatrix * vec4(position, 1.0);
    outColour = inColour;
    outTexCoord = texCoord;
}