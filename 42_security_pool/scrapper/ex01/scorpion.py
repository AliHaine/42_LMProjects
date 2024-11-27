from PIL import Image, ExifTags
import sys

img = None

def image_data():
    print("Format:", img.format)
    print("Size:", img.size)
    print("Mode:", img.mode)

    print("All metadata:", img.info)


def image_data_gif():
    print("Format:", img.format)
    print("Size:", img.size)
    print("Mode:", img.mode)

    # GIF-specific metadata
    print("Number of frames:", img.n_frames)  # Total number of frames
    print("Duration:", img.info.get("duration"), "ms")  # Duration per frame in milliseconds
    print("Loop count:", img.info.get("loop", 1))

    print("All metadata:", img.info)


def image_data_exif():
    img_exif = img.getexif()
    if img_exif is None:
        print('Sorry, image has no exif data.')
    else:
        for key, val in img_exif.items():
            if key in ExifTags.TAGS:
                print(f'{ExifTags.TAGS[key]}:{val}')
            else:
                print(f'{key}:{val}')

for img_link in sys.argv[1:]:
    print("----------------------------------")
    print(f"Try to open the image {img_link}")
    try:
        img = Image.open(img_link)
    except IOError:
        print("Impossible to open this image..")
        continue
    print(f"Image {img_link} opened")
    if img_link.endswith(".jpg") or img_link.endswith(".jpeg"):
        image_data_exif()
    elif img_link.endswith(".gif"):
        image_data_gif()
    elif img_link.endswith(".png") or img_link.endswith(".bmp"):
        image_data()
    else:
        print("image format not supported.")
    img.close()